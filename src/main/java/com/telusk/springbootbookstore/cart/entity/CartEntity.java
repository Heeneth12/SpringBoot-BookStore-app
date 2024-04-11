package com.telusk.springbootbookstore.cart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telusk.springbootbookstore.books.entity.BookEntity;
import com.telusk.springbootbookstore.order.entity.OrderEntity;
import com.telusk.springbootbookstore.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
public class CartEntity {

    @Id
    @GeneratedValue
    private Long  cartId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserEntity userEntity;
    private boolean ordered;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;


    private long cartQuantity;
    private long cartTotalPrice;


}
