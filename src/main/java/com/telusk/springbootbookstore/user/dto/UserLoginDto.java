package com.telusk.springbootbookstore.user.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class UserLoginDto {


    private  String email;
    private String password;


    public UserLoginDto(){

    }

    public UserLoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
