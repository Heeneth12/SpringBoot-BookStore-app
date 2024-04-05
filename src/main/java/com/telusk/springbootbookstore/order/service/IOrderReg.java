package com.telusk.springbootbookstore.order.service;

import com.telusk.springbootbookstore.order.entity.OrderEntity;

import java.util.List;

public interface IOrderReg  {

    String placeOrderByJWT(OrderEntity orderEntity);
    List<OrderEntity> getOrderDetailsByID(long orderID);


}
