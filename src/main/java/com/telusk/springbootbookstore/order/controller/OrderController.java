package com.telusk.springbootbookstore.order.controller;


import com.telusk.springbootbookstore.order.service.IOrderReg;
import com.telusk.springbootbookstore.user.service.IUserReg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
public class OrderController {

    @Autowired
    IOrderReg iOrderReg;


    @PutMapping("/placeOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestHeader long token){




        return "order is placed Successfully";
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
