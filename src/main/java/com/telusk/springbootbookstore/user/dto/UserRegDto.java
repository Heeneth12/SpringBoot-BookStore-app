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
    private  int age;
    private String gender;
    private Boolean userVerify;

    public UserRegDto() {
    }


    public UserRegDto(String firstName, String lastName, String email, String password, int age, String gender, Boolean userVerify) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.userVerify =userVerify;
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

    public void setUserVerify(boolean b) {
    }
}
