package com.telusk.springbootbookstore.user.config;

import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class UserOTP {
    Random randomNum = new Random();
    public int  otpgen(){
        int  userOTP = randomNum.nextInt(10000,99999);
        return  userOTP;
    }

}
