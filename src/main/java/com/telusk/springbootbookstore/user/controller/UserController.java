package com.telusk.springbootbookstore.user.controller;


import com.telusk.springbootbookstore.user.config.EmailSender;
import com.telusk.springbootbookstore.user.config.UserJwt;
import com.telusk.springbootbookstore.user.dto.UserLoginDto;
import com.telusk.springbootbookstore.user.service.IUserReg;
import com.telusk.springbootbookstore.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseStatus(HttpStatus.OK)
@CrossOrigin("http://localhost:3000")
public class UserController {


    @Autowired
    IUserReg iUserReg;

    @Autowired
    EmailSender emailSender;


    @Autowired
    UserJwt userJwt;

    @PostMapping("/Reg")
    @ResponseStatus(HttpStatus.CREATED)
    public  String userRegistration(@RequestBody UserEntity userEntity){
        return iUserReg.userRegistration(userEntity);
    }

    @PostMapping("/login")
    public String userLogin(@RequestBody UserLoginDto userLoginDto){
        return  iUserReg.userLogin(userLoginDto);
    }


//    @GetMapping("getByJWT")
//    public List<UserEntity> getByJWT(@RequestHeader String token){
//        return  iUserReg.getUserByJWT(token);
//    }

}