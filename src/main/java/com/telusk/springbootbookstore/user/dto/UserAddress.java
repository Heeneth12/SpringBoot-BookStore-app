package com.telusk.springbootbookstore.user.dto;


import lombok.Data;

@Data
public class UserAddress {
    private Long id;
    private String pinCode;
    private String locality;
    private String phoneNumber;
    private String address;
    private String city;
    private String landmark;
    private Long UserID;

}
