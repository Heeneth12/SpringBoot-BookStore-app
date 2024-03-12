package com.telusk.springbootbookstore.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@NoArgsConstructor
@Getter
@Setter
@Entity
//userDetails
public class UserEntity{

    @Id
    @GeneratedValue
    private  Long id;
    private  String firstName;
    private  String lastName;
    private  String email;
    @Column(nullable = false)
    private String password;
    private Integer age;
    private String gender;
    private Boolean userVerify;


    public UserEntity(Long id, String firstName, String lastName, String email, String password, Integer age, String gender , Boolean userVerify) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.userVerify = userVerify;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", userVerify=" + userVerify +
                '}';
    }

}
