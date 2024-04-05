package com.telusk.springbootbookstore.order.service;

import com.telusk.springbootbookstore.order.entity.OrderEntity;
import com.telusk.springbootbookstore.order.repository.OrderRepo;
import com.telusk.springbootbookstore.user.config.UserJwt;
import com.telusk.springbootbookstore.user.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Component
public class OrderImpl implements IOrderReg {


    @Autowired
    OrderRepo orderRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserJwt userJwt;


    @Override
    public String placeOrderByJWT(OrderEntity orderEntity ) {

        orderRepo.save(orderEntity);
        return "order successful";
    }
    @Override
    public List<OrderEntity> getOrderDetailsByID(long orderID) {
        return orderRepo.findAllById(Collections.singleton(orderID));
    }


}
