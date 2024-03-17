package com.telusk.springbootbookstore.cart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telusk.springbootbookstore.books.entity.BookEntity;
import com.telusk.springbootbookstore.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class CartEntity {

    @Id
    @GeneratedValue
    private Long  cartId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;

    private long cartQuantity;
    private long cartTotalPrice;

    public CartEntity() {
    }


    public CartEntity(Long cartId, UserEntity userEntity, BookEntity bookEntity, long cartQuantity, long cartTotalPrice) {
        this.cartId = cartId;
        this.userEntity = userEntity;
        this.bookEntity = bookEntity;
        this.cartQuantity = cartQuantity;
        this.cartTotalPrice = cartTotalPrice;
    }

    @Override
    public String toString() {
        return "CartEntity{" +
                "id=" + cartId +
                ", userEntity=" + userEntity +
                ", bookEntity=" + bookEntity +
                ", cartQuantity=" + cartQuantity +
                ", cartTotalPrice=" + cartTotalPrice +
                '}';
    }
}
