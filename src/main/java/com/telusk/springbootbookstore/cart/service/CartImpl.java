package com.telusk.springbootbookstore.cart.service;

import com.telusk.springbootbookstore.books.entity.BookEntity;
import com.telusk.springbootbookstore.books.repository.BooksRepo;
import com.telusk.springbootbookstore.cart.entity.CartEntity;
import com.telusk.springbootbookstore.cart.repository.CartRepo;
import com.telusk.springbootbookstore.user.entity.UserEntity;
import com.telusk.springbootbookstore.user.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartImpl implements ICartReg {

    @Autowired
    CartRepo cartRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    BooksRepo booksRepo;

    @Override
    public void addToCart(Long userId, Long bookId, long quantity) {
        UserEntity userEntity = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));

        BookEntity bookEntity = booksRepo.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with ID: " + bookId));

        if (bookEntity.getBookQuantity() < quantity) {
            throw new IllegalArgumentException("Not enough quantity available for the book: " + bookEntity.getBookName());
        }

        CartEntity cartItem = userEntity.getCarts().stream()
                .filter(cart -> cart.getBookEntity().getBookId().equals(bookId))
                .findFirst()
                .orElse(new CartEntity());

        cartItem.setUserEntity(userEntity);
        cartItem.setBookEntity(bookEntity);
        cartItem.setCartQuantity(cartItem.getCartQuantity() + quantity);
        cartItem.setCartTotalPrice(cartItem.getCartTotalPrice() + (quantity * bookEntity.getBookPrize()));

        if (cartItem.getCartId() == null) {
            userEntity.getCarts().add(cartItem);
        }

        cartRepo.save(cartItem); // Save the cartItem instead of the userEntity
        System.out.println("added data");
    }

    @Override
    public List<CartEntity> getAllCartItems(Long UserId) {
        return cartRepo.findByUserEntityId(UserId);
    }

    @Override
    public String removeCartItemByCartID(Long cartID) {
        cartRepo.deleteById(cartID);
        return "successfully removed the item from cart";
    }

    @Override
    @Transactional
    // method with @Transactional to ensure that all changes are committed as a single transaction.
    public void confirmOrder(Long userId) {
        List<CartEntity> cartItems = cartRepo.findByUserEntityId(userId);
        for (CartEntity cartItem : cartItems) {
            cartItem.setOrdered(true);
            cartRepo.save(cartItem); // Save the updated cart item
        }
        System.out.println("Order confirmed for user with ID: " + userId);
    }


}
