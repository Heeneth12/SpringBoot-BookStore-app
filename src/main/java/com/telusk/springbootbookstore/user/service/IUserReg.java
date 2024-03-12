package com.telusk.springbootbookstore.user.service;

import com.telusk.springbootbookstore.user.dto.UserLoginDto;
import com.telusk.springbootbookstore.user.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserReg {


    String userRegistration(UserEntity userEntity);
    String userLogin(UserLoginDto userLoginDto);

    List<Optional<UserEntity>> getUserByJWT(String token);
}