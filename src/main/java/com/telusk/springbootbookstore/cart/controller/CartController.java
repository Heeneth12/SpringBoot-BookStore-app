package com.telusk.springbootbookstore.cart.controller;


import org.springframework.web.bind.annotation.*;

@RestController()
public class CartController {

    //end point to add to cart item
    @PostMapping("/addToCart")
    public String addToCart(  ){
        return "Item is added to cart";
    }

    @PostMapping("/removeCart")
    public String removeFromCart(){
        return "remove from cart";
    }



    @GetMapping("getAll/cartItems")
    public String getAllCartItems(){
        return "all cart items ";
    }

    @GetMapping("/allCartForUser")
    public String getAllCartItemsForUser(){
        return "All cart itesm fir user";
    }


    @PutMapping("/cart/quantityUpdate")
    public  String updateQuantity(){
        return "update All useing token";
    }


    @DeleteMapping("removeCart/byUser")
    public  String removeByUserId(){
        return "remove by user id";
    }
}
