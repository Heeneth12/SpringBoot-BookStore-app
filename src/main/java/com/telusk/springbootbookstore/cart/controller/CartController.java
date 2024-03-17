package com.telusk.springbootbookstore.cart.controller;


import com.telusk.springbootbookstore.books.entity.BookEntity;
import com.telusk.springbootbookstore.cart.dto.AddToCartRequest;
import com.telusk.springbootbookstore.cart.dto.CartItemRequest;
import com.telusk.springbootbookstore.cart.entity.CartEntity;
import com.telusk.springbootbookstore.cart.service.ICartReg;
import com.telusk.springbootbookstore.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin("http://localhost:4200/")
public class CartController {

    @Autowired
    ICartReg iCartReg;

    //end point to add to cart item
    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(@RequestBody AddToCartRequest request) {

        try {
            iCartReg.addToCart(request.getUserId(), request.getBookId(), request.getQuantity());
            return ResponseEntity.ok("Item added to cart successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add item to cart: " + e.getMessage());
        }

    }



    //To get cart items
    @GetMapping("/getAllCartItems/{userId}")
    public ResponseEntity<List<CartEntity>> getAllCartItems(@PathVariable Long userId) {
        List<CartEntity> cartItems = iCartReg.getAllCartItems(userId);
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
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
