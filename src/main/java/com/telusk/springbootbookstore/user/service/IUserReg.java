package com.telusk.springbootbookstore.user.service;

import com.telusk.springbootbookstore.user.dto.UserEmail;
import com.telusk.springbootbookstore.user.dto.UserForgotPasswordDto;
import com.telusk.springbootbookstore.user.dto.UserResetPassword;
import com.telusk.springbootbookstore.user.dto.UserLoginDto;
import com.telusk.springbootbookstore.user.entity.UserEntity;

import java.util.Optional;

public interface IUserReg {


    String userRegistration(UserEntity userEntity);
    String userLogin(UserLoginDto userLoginDto);

    Optional<UserEntity> getUserByJWT(String token);

    String resetPassword(UserResetPassword userResetPassword);

    String userOtpGen(UserEmail userEmail);
    String forgotPasswordSetByOtp(UserForgotPasswordDto userForgotPasswordDto);

}