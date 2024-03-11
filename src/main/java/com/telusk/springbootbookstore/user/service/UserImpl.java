package com.telusk.springbootbookstore.user.service;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.telusk.springbootbookstore.user.config.EmailSender;
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

    @Autowired
    EmailSender emailSender;

    public String userRegistration(UserEntity userEntity) {

        userRepo.save(userEntity);
        String body =" Thanks for registering in Book store app."+ " click here to verify you account   " + "http://localhost:8081/login" ;
        String subject = "register successfully and get verify your account";
        emailSender.sendEmail( userEntity.getFirstName() ,userEntity.getEmail() ,subject, body);
        return  "User register successfully";
    }


    public String userLogin(UserLoginDto userLoginDto) {
        UserEntity userEntity = userRepo.findByUsernameAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());

        if (userEntity != null) {
            // User exists, generate JWT token
            String token = userJwt.createToken(userEntity.getId());
            String body =" Thanks for verification your account in Book store app.";
            String subject = "account verification  successfully..!";
            emailSender.sendEmail( userLoginDto.getEmail(),userLoginDto.getEmail() ,subject, body);
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