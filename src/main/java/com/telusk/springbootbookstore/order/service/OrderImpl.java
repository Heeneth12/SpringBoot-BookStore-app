package com.telusk.springbootbookstore.order.service;

import com.telusk.springbootbookstore.order.repository.OrderRepo;
import com.telusk.springbootbookstore.user.config.UserJwt;
import com.telusk.springbootbookstore.user.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class OrderImpl implements IOrderReg {


    @Autowired
    OrderRepo orderRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserJwt userJwt;


    @Override
    public String placeOrderByJWT(long Token) {
        if( userRepo.existsById(userJwt.decodeToken(String.valueOf(Token)))){
            return "present";
        }
        return "user not Present";
    }
}
