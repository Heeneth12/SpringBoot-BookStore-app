package com.telusk.springbootbookstore.order.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class OrderController {

    @PutMapping("/placeOrder")
    public String placeOrder(){
        return "order is placed";
    }

    @DeleteMapping("/cancelOrder")
    public String cancelOrder(){
        return "order is placed";

    }

    @GetMapping("/getAllOrders")
    public String getAllOrders(){
        return "order is placed";

    }

    @GetMapping("/getAllOrder/byUSer")
    public String getAllOrdersForUser(){
        return "order is placed";

    }

}
