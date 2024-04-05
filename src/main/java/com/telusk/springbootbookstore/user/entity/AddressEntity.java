package com.telusk.springbootbookstore.user.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AddressEntity {


    @Id
    @GeneratedValue
    private Long id;
    private String pinCode;
    private String locality;
    private String phoneNumber;
    private String address;
    private String city;
    private String landmark;
    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserEntity user;

}
