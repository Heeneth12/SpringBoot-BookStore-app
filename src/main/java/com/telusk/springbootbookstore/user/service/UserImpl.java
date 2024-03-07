package com.telusk.springbootbookstore.user.service;

import com.telusk.springbootbookstore.user.dto.UserDto;
import com.telusk.springbootbookstore.user.entity.UserEntity;
import com.telusk.springbootbookstore.user.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class UserImpl implements IUserReg {


    @Autowired
    UserRepo userRepo;
    public String UserRegistration(UserEntity userEntity) {

        userRepo.save(userEntity);
        return  "User register successfully";
    }
    public List<UserDto> getUserById(Long id){

        return userRepo.findAllById(Collections.singleton(id))
                .stream()
                .map(userEntity -> new UserDto(
                        userEntity.getUserId(),
                        userEntity.getUserFirstName(),
                        userEntity.getUserLastName(),
                        userEntity.getUserEmail()

                )).collect(Collectors.toList());
    }
}
