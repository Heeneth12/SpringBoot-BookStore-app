package com.telusk.springbootbookstore.user.service;

import com.telusk.springbootbookstore.user.config.EmailSender;
import com.telusk.springbootbookstore.user.config.PasswordEncoder;
import com.telusk.springbootbookstore.user.config.UserJwt;
import com.telusk.springbootbookstore.user.config.UserOTP;
import com.telusk.springbootbookstore.user.dto.*;
import com.telusk.springbootbookstore.user.entity.UserEntity;
import com.telusk.springbootbookstore.user.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Optional;


@Component
public class UserImpl implements IUserReg {


    @Autowired
    UserRepo userRepo;

    @Autowired
    UserJwt userJwt;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    EmailSender emailSender;

    @Autowired
    UserOTP userOTP;

    public  Integer otpChecker;


    public String userRegistration(UserRegDto userRegDto) {

        //password encoder
        String encryptedPassword =passwordEncoder.encode(userRegDto.getPassword());
        userRegDto.setPassword(encryptedPassword);

        //setting user verify  false to get true need to login once;
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userRegDto.getFirstName());
        userEntity.setLastName(userRegDto.getLastName());
        userEntity.setAge(userRegDto.getAge());
        userEntity.setEmail(userRegDto.getEmail());
        userEntity.setPassword(userRegDto.getPassword());
        userEntity.setGender(userRegDto.getGender());
        userEntity.setUserVerify(false);
        System.out.println(userEntity.toString());

        userRepo.save(userEntity);
        String body =" Thanks for registering in Book store app."+ " click here to verify you account   " + "http://localhost:8081/login" ;
        String subject = "register successfully and get verify your account";
        emailSender.sendEmail( userEntity.getFirstName() ,userEntity.getEmail() ,subject, body);
//        System.out.println(userEntity.getPassword());
        return  "User register successfully";

    }


    public HashMap<String,String> userLogin(UserLoginDto userLoginDto) {
//        UserEntity userEntity = userRepo.findByUsernameAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());
        UserEntity userEntity = userRepo.findByEmail(userLoginDto.getEmail());



        if (userEntity != null && passwordEncoder.matches(userLoginDto.getPassword() ,userEntity.getPassword())) {
            if(userEntity.getUserVerify().equals(false)){
                String body =" Thanks for verification your account in Book store app.";
                String subject = "account verification  successfully..!";
                emailSender.sendEmail( userLoginDto.getEmail(),userLoginDto.getEmail() ,subject, body);
                userEntity.setUserVerify(true);
                userRepo.save(userEntity);
            }
            // User exists, generate JWT token
            String token = userJwt.createToken(userEntity.getId());
            HashMap<String, String> data = new HashMap<String, String>();
            data.put("status" ,"ok");
            data.put("token", token);
            return data;
        } else {
            return null;
        }
    }

    @Override
    public Optional<UserEntity> getUserByJWT(String token) {
            Long userId = userJwt.decodeToken(token);
            System.out.println(" servece"+userId);
            return userRepo.findById(userId);
    }



    @Override
    public String resetPassword(UserResetPassword userResetPassword){
         UserEntity userEntity = userRepo.findByEmail(userResetPassword.getEmail());
         if(userEntity != null){
             //checking new present password and old password to get access to change new password
             if(passwordEncoder.matches(userResetPassword.getPassword(),userEntity.getPassword())){

                 //now update the password data
                 userEntity.setPassword(passwordEncoder.encode(userResetPassword.getNewPassword()));
                 userRepo.save(userEntity);
                 System.out.println(userEntity.toString());
                 return "Password reset successfully";
             }
             return "not match ";
         }else {
             return " no user ";
         }
    }

    public String userOtpGen(UserEmail userEmail){

        UserEntity userEntity = userRepo.findByEmail(userEmail.getEmail());
        if( userEntity != null){
            otpChecker = userOTP.otpgen();

            String body ="OTP generated :" +  otpChecker  ;

            String subject = "OTP generated successfully and sent  reset your password ";
            emailSender.sendEmail( userEntity.getFirstName() ,userEntity.getEmail() ,subject, body);
        }
        return "user not found";
    }

    public String forgotPasswordSetByOtp(UserForgotPasswordDto userForgotPasswordDto){

       UserEntity userEntity = userRepo.findByEmail(userForgotPasswordDto.getEmail());
       System.out.println(otpChecker);

       if(otpChecker.equals(userForgotPasswordDto.getOtp())){

           userEntity.setPassword(passwordEncoder.encode(userForgotPasswordDto.getNewPassword()));
           userRepo.save(userEntity);
           String body =  userEntity.getEmail()  +" your password is reset successfully  " ;

           String subject = "Password reset successfully..!";
           emailSender.sendEmail( userEntity.getFirstName() ,userEntity.getEmail() ,subject, body);

        return "successfully reset passeord";
       }
       else {
           return "Otp not match";
       }

   }

}