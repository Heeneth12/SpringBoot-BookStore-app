package com.telusk.springbootbookstore.cart.entity;

import com.telusk.springbootbookstore.books.entity.BookEntity;
import com.telusk.springbootbookstore.user.entity.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class CartEntity {

    @Id
    private Long cartID;
//  private UserEntity userEntity;
//  private BookEntity bookEntity;
    private  long cartQuantity;
    private long cartTotalPrice;

    public CartEntity(){

    }

    public CartEntity(Long cartID, long cartQuantity, long cartTotalPrice) {
        this.cartID = cartID;
        this.cartQuantity = cartQuantity;
        this.cartTotalPrice = cartTotalPrice;
    }

    @Override
    public String toString() {
        return "CartEntity{" +
                "cartID=" + cartID +
                ", cartQuantity=" + cartQuantity +
                ", cartTotalPrice=" + cartTotalPrice +
                '}';
    }
}
