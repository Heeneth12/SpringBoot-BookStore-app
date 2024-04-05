package com.telusk.springbootbookstore.order.controller;


import com.telusk.springbootbookstore.order.dto.OrderSummery;
import com.telusk.springbootbookstore.order.entity.OrderEntity;
import com.telusk.springbootbookstore.order.service.IOrderReg;
import com.telusk.springbootbookstore.user.config.UserJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin("http://localhost:4200/")
public class OrderController {

    @Autowired
    IOrderReg iOrderReg;

    @Autowired
    UserJwt userJwt;


    @PostMapping("/placeOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> placeOrder(@RequestBody OrderSummery orderSummery){
        String message = iOrderReg.placeOrderByJWT(orderSummery);
        return ResponseEntity.status(HttpStatus.CREATED).body("{\"message\": \"" + message + "\"}");
    }

    @DeleteMapping("/cancelOrder")
    public String cancelOrder(){
        return "order is placed";

    }

    @GetMapping("/getOrdersByJWT")
    public List<OrderEntity> getAllOrders(@RequestHeader String token){

        Long userId = userJwt.decodeToken(token);
        return iOrderReg.getOrderDetailsByID(userId);

    }

    @GetMapping("/getAllOrder/byUSer")
    public String getAllOrdersForUser(){
        return "order is placed";

    }

}
