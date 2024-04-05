package com.telusk.springbootbookstore.order.controller;


import com.telusk.springbootbookstore.order.entity.OrderEntity;
import com.telusk.springbootbookstore.order.service.IOrderReg;
import com.telusk.springbootbookstore.user.service.IUserReg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class OrderController {

    @Autowired
    IOrderReg iOrderReg;


    @PutMapping("/placeOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderEntity orderEntity){
        return iOrderReg.placeOrderByJWT(orderEntity);
    }

    @DeleteMapping("/cancelOrder")
    public String cancelOrder(){
        return "order is placed";

    }

    @GetMapping("/getOrdersById/{id}")
    public List<OrderEntity> getAllOrders(@PathVariable Long id){
        return iOrderReg.getOrderDetailsByID(id);

    }

    @GetMapping("/getAllOrder/byUSer")
    public String getAllOrdersForUser(){
        return "order is placed";

    }

}
