package com.telusk.springbootbookstore.user.dto;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserResetPassword {

    private  String email;
    private  String password;
    private String NewPassword;

}
