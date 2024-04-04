package com.telusk.springbootbookstore.user.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telusk.springbootbookstore.cart.entity.CartEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
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

    // One-to-one relationship with AddressEntity
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private AddressEntity address;


}
