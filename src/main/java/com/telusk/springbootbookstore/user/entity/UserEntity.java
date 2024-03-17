package com.telusk.springbootbookstore.user.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telusk.springbootbookstore.cart.entity.CartEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    //A user can have multiple items in cart
    @OneToMany(mappedBy = "userEntity")
    @JsonIgnore
    private List<CartEntity> carts;

    public UserEntity(Long id, String firstName, String lastName, String email, String password, Integer age, String gender, Boolean userVerify, List<CartEntity> carts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.userVerify = userVerify;
        this.carts = carts;
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
