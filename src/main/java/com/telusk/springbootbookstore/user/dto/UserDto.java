package com.telusk.springbootbookstore.user.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;

    // other fields as needed

    public UserDto() {
    }

    public UserDto(Long userId, String userFirstName, String userLastName, String userEmail) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }


}
