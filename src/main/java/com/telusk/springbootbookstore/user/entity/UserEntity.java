package com.telusk.springbootbookstore.user.entity;

import jakarta.persistence.*;
import lombok.*;
@NoArgsConstructor
@Getter
@Setter
@Entity
//userDetails
public class UserEntity{

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private  Long id;
    private  String firstName;
    private  String lastName;
    private  String email;
    private String password;
    private Integer age;
    private String gender;


    public UserEntity(Long id, String firstName, String lastName, String email, String password, Integer age, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
