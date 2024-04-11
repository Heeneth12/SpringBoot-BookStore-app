package com.telusk.springbootbookstore.order.service;

import com.telusk.springbootbookstore.cart.entity.CartEntity;
import com.telusk.springbootbookstore.cart.repository.CartRepo;
import com.telusk.springbootbookstore.order.dto.OrderSummery;
import com.telusk.springbootbookstore.order.entity.OrderEntity;
import com.telusk.springbootbookstore.order.repository.OrderRepo;
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
    CartRepo cartRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public String placeOrderByJWT(OrderSummery orderSummery ) {
//        CartEntity cart = new CartEntity();
//        cart
        OrderEntity orderEntity = convertToOrderEntity(orderSummery);
        orderRepo.save(orderEntity);

        // Update CartEntity
        CartEntity cartEntity = cartRepo.findById(orderSummery.getCartID()).orElse(null);
        if (cartEntity != null) {
            cartEntity.setOrdered(true);
            cartRepo.save(cartEntity);
        }
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
        // Retrieve all order entities associated with the user ID
        return orderRepo.findAllByUserEntity_Id(userId);
    }
}
