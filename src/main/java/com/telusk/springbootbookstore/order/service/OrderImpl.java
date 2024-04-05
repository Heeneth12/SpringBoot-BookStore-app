package com.telusk.springbootbookstore.order.service;

import com.telusk.springbootbookstore.order.dto.OrderSummery;
import com.telusk.springbootbookstore.order.entity.OrderEntity;
import com.telusk.springbootbookstore.order.repository.OrderRepo;
import com.telusk.springbootbookstore.user.config.UserJwt;
import com.telusk.springbootbookstore.user.entity.UserEntity;
import com.telusk.springbootbookstore.user.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public String placeOrderByJWT(OrderSummery orderSummery ) {
        OrderEntity orderEntity = convertToOrderEntity(orderSummery);
        orderRepo.save(orderEntity);
        return "order successful";
    }
    private OrderEntity convertToOrderEntity(OrderSummery orderSummery) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(orderSummery.getOrderId());
        orderEntity.setOrderData(orderSummery.getOrderData());
        orderEntity.setOrderPrice(orderSummery.getOrderPrice());
        orderEntity.setOrderQuantity(orderSummery.getOrderQuantity());
        orderEntity.setOrderCancel(orderSummery.getOrderCancel());

        // Fetch the user entity by ID from the database and set it in the order entity
        UserEntity userEntity = userRepo.findById(orderSummery.getUserID()).orElse(null);
        orderEntity.setUserEntity(userEntity);
        return orderEntity;
    }
    @Override
    public List<OrderEntity> getOrderDetailsByID(long userId) {
        return orderRepo.findAllByUserEntity_Id(userId);

    }


}
