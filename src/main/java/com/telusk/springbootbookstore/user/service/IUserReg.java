package com.telusk.springbootbookstore.user.service;

import com.telusk.springbootbookstore.user.dto.UserDto;
import com.telusk.springbootbookstore.user.entity.UserEntity;

import java.util.List;

public interface IUserReg {


    String UserRegistration(UserEntity userEntity);
    List<UserDto> getUserById(Long id);



}
