package com.telusk.springbootbookstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    private Long userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private LocalDate userLocalDate;
    private LocalDate userRegisteredDate;
    private String userPassword;
    private Boolean UserVerify;
    private int UserOtp;
}
