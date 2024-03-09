package com.telusk.springbootbookstore.user.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegDto  {
    private  String firstName;
    private  String lastName;
    private  String email;
    private String password;

    public UserRegDto() {
    }

    public UserRegDto(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserRegDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
