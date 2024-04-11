package com.telusk.springbootbookstore.user.service;

import com.telusk.springbootbookstore.user.dto.*;
import com.telusk.springbootbookstore.user.entity.AddressEntity;
import com.telusk.springbootbookstore.user.entity.UserEntity;

import java.util.HashMap;
import java.util.Optional;

public interface IUserReg {


    String userRegistration(UserRegDto userRegDto);
    HashMap<String,String> userLogin(UserLoginDto userLoginDto);

    Optional<UserEntity> getUserByJWT(String token);

    String resetPassword(UserResetPassword userResetPassword);

    String userOtpGen(UserEmail userEmail);
    String forgotPasswordSetByOtp(UserForgotPasswordDto userForgotPasswordDto);

    Optional<UserEntity> getUserById(Long id);

    String addAddressToUser(UserAddress userAddress ,  Long Id);

}