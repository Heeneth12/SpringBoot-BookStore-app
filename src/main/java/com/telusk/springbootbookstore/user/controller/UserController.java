package com.telusk.springbootbookstore.user.controller;


import com.telusk.springbootbookstore.user.dto.UserDto;
import com.telusk.springbootbookstore.user.service.IUserReg;
import com.telusk.springbootbookstore.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    IUserReg iUserReg;

    @PostMapping("/userReg")
    @ResponseStatus(HttpStatus.CREATED)
    public  String userRegistration(@RequestBody UserEntity userEntity){
        return iUserReg.UserRegistration(userEntity);
    }

    @GetMapping("getUserById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getUserById(@PathVariable Long id){
        return iUserReg.getUserById(id);
    }



}
