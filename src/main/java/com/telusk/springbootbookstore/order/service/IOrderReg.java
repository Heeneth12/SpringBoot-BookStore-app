package com.telusk.springbootbookstore.order.service;

import com.telusk.springbootbookstore.order.dto.OrderSummery;
import com.telusk.springbootbookstore.order.entity.OrderEntity;

import java.util.List;

public interface IOrderReg  {

    String placeOrderByJWT(OrderSummery orderSummery);
    List<OrderEntity> getOrderDetailsByID(long orderID);



}
