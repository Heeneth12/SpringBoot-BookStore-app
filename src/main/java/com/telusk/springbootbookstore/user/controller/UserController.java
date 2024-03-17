package com.telusk.springbootbookstore.user.controller;


import com.telusk.springbootbookstore.user.config.EmailSender;
import com.telusk.springbootbookstore.user.config.UserJwt;
import com.telusk.springbootbookstore.user.config.UserOTP;
import com.telusk.springbootbookstore.user.dto.*;
import com.telusk.springbootbookstore.user.service.IUserReg;
import com.telusk.springbootbookstore.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {


    @Autowired
    IUserReg iUserReg;

    @Autowired
    EmailSender emailSender;


    @Autowired
    UserJwt userJwt;



    @PostMapping("/Reg")
    @ResponseStatus(HttpStatus.CREATED)
    public  String userRegistration(@RequestBody UserRegDto userRegDto){
        return iUserReg.userRegistration(userRegDto);
    }

    @PostMapping("/login")
    public HashMap<String, String> userLogin(@RequestBody UserLoginDto userLoginDto){
        return  iUserReg.userLogin(userLoginDto);
    }


    @GetMapping("/getByJWT")
    public Optional<UserEntity> getByJWT(@RequestHeader String token){
        System.out.println( "controller" +token);
        return  iUserReg.getUserByJWT(token);
    }

    @PostMapping("/resetPassword")
    public String editPasswordByOldPassword(@RequestBody UserResetPassword userResetPassword){
        return iUserReg.resetPassword(userResetPassword);

    }

    @PostMapping("/forgotPassword")
    public String forgotPassword (@RequestBody UserEmail userEmail){
        return iUserReg.userOtpGen(userEmail);
    }

    @PostMapping("/setTheForgotPassword ")
    public String setTheForgotPassword( @RequestBody UserForgotPasswordDto userForgotPasswordDto){

        return iUserReg.forgotPasswordSetByOtp(userForgotPasswordDto);
    }

}