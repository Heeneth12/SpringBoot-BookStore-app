package com.telusk.springbootbookstore.cart.controller;


import com.telusk.springbootbookstore.books.entity.BookEntity;
import com.telusk.springbootbookstore.cart.dto.AddToCartRequest;
import com.telusk.springbootbookstore.cart.dto.CartItemRequest;
import com.telusk.springbootbookstore.cart.entity.CartEntity;
import com.telusk.springbootbookstore.cart.service.ICartReg;
import com.telusk.springbootbookstore.user.config.UserJwt;
import com.telusk.springbootbookstore.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@CrossOrigin("http://localhost:4200/")
public class CartController {

    @Autowired
    ICartReg iCartReg;


    @Autowired
    UserJwt userJwt;

    //end point to add to cart item
    @PostMapping("/addToCart")
    public ResponseEntity<Map<String, String>> addToCart(@RequestBody AddToCartRequest request , @RequestHeader String token) {
        long userId = userJwt.decodeToken(token);
        try {
            iCartReg.addToCart(userId , request.getBookId(), request.getQuantity());
            // Create a map to represent the response data
            Map<String, String> responseData = new HashMap<>();
            responseData.put("message", "Item added to cart successfully.");
            // Return a ResponseEntity with the response data and HTTP status OK
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            // If an exception occurs, return an error response with HTTP status INTERNAL_SERVER_ERROR
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to add item to cart: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    //To get cart items
    @GetMapping("/getAllCartItems")
    public ResponseEntity<List<CartEntity>> getAllCartItems(@RequestHeader String token) {
        long userId = userJwt.decodeToken(token);
        List<CartEntity> cartItems = iCartReg.getAllCartItems(userId);
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    @PostMapping("/removeFromCartByCartID/{cartID}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String removeFromCartByCartID( @PathVariable Long cartID){
        System.out.println(cartID);
        return iCartReg.removeCartItemByCartID(cartID);
    }

    @PostMapping("/confirmOrder")
    public ResponseEntity<Map<String, String>> confirmOrder(@RequestHeader String token) {
        long userId = userJwt.decodeToken(token);
        try {
            iCartReg.confirmOrder(userId);
            // Create a map to represent the response data
            Map<String, String> responseData = new HashMap<>();
            responseData.put("message", "Order confirmed successfully.");
            // Return a ResponseEntity with the response data and HTTP status OK
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            // If an exception occurs, return an error response with HTTP status INTERNAL_SERVER_ERROR
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to confirm order: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
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

