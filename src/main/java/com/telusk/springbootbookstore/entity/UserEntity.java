package com.telusk.springbootbookstore.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@Entity
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

    public UserEntity() {
    }
    public UserEntity(Long userId, String userFirstName, String userLastName, String userEmail, LocalDate userLocalDate, LocalDate userRegisteredDate, String userPassword, Boolean userVerify, int userOtp) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userLocalDate = userLocalDate;
        this.userRegisteredDate = userRegisteredDate;
        this.userPassword = userPassword;
        UserVerify = userVerify;
        UserOtp = userOtp;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userLocalDate=" + userLocalDate +
                ", userRegisteredDate=" + userRegisteredDate +
                ", userPassword='" + userPassword + '\'' +
                ", UserVerify=" + UserVerify +
                ", UserOtp=" + UserOtp +
                '}';
    }
}
