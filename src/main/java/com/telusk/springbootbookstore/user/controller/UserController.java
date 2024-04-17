package com.telusk.springbootbookstore.user.controller;


import com.telusk.springbootbookstore.user.config.EmailSender;
import com.telusk.springbootbookstore.user.config.UserJwt;
import com.telusk.springbootbookstore.user.dto.*;
import com.telusk.springbootbookstore.user.entity.AddressEntity;
import com.telusk.springbootbookstore.user.service.IUserReg;
import com.telusk.springbootbookstore.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
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
    public ResponseEntity<Map<String, String>> forgotPassword(@RequestBody UserEmail userEmail) {
        String otpMessage = iUserReg.userOtpGen(userEmail);
        Map<String, String> response = new HashMap<>();
        response.put("message", otpMessage);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/setTheForgotPassword")
    public ResponseEntity<Map<String ,String>> setTheForgotPassword( @RequestBody UserForgotPasswordDto userForgotPasswordDto){
        String passwordMessage =  iUserReg.forgotPasswordSetByOtp(userForgotPasswordDto);
        Map<String, String> response = new HashMap<>();
        response.put("message" , passwordMessage);
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/Id/{id}")
    public Optional<UserEntity> getUserById(@PathVariable Long id){
        return iUserReg.getUserById(id);
    }


    @PostMapping("add/address/{Id}")
    public String addAddress(@RequestBody UserAddress userAddress , Long Id){

        return iUserReg.addAddressToUser(userAddress,Id);

    }

}