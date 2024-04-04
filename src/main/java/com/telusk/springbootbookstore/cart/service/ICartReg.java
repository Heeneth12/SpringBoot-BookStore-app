package com.telusk.springbootbookstore.cart.service;

import com.telusk.springbootbookstore.books.entity.BookEntity;
import com.telusk.springbootbookstore.cart.entity.CartEntity;
import com.telusk.springbootbookstore.user.entity.UserEntity;

import java.util.List;

public interface ICartReg {

     void addToCart(Long userId, Long bookId, long quantity);

     List<CartEntity> getAllCartItems(Long UserId);

     String removeCartItemByCartID(Long cartId);
}