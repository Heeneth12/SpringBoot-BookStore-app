package com.telusk.springbootbookstore.user.service;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.telusk.springbootbookstore.user.config.UserJwt;
import com.telusk.springbootbookstore.user.dto.UserLoginDto;
import com.telusk.springbootbookstore.user.entity.UserEntity;
import com.telusk.springbootbookstore.user.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
public class UserImpl implements IUserReg {


    @Autowired
    UserRepo userRepo;

    @Autowired
    UserJwt userJwt;
    public String UserRegistration(UserEntity userEntity) {

        userRepo.save(userEntity);
        return  "User register successfully";
    }


    public String UserLogin(UserLoginDto userLoginDto) {
        UserEntity userEntity = userRepo.findByUsernameAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());

        if (userEntity != null) {
            // User exists, generate JWT token
            String token = userJwt.createToken(userEntity.getFirstName());
            return "Login successful. JWT Token: " + token;
        } else {
            return "Invalid credentials. Login failed.";
        }
    }

    @Override
    public List<UserEntity> getUserByJWT(String token) {
        try {
            String userFirstName = userJwt.decodeToken(token);
            UserEntity userEntity = userRepo.findByFirstName(userFirstName);
            return Collections.singletonList(userEntity);
        } catch (JWTVerificationException e) {
            // Handle JWT verification exception
            e.printStackTrace();
            return Collections.emptyList();
        }
    }








}