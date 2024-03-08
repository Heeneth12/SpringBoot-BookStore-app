package com.telusk.springbootbookstore.user.dto;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRegDto {


    private Long userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
    private LocalDate userLocalDate;
    private LocalDate userRegisteredDate;

}
