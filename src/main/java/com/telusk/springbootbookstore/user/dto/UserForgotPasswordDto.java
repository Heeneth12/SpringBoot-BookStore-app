package com.telusk.springbootbookstore.user.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserForgotPasswordDto {
    private  String email;
    private  Integer otp;
    private String NewPassword;
}
