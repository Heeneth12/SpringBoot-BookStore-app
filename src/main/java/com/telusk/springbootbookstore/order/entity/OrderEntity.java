package com.telusk.springbootbookstore.order.entity;
import com.telusk.springbootbookstore.books.entity.BookEntity;
import com.telusk.springbootbookstore.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderEntity {

    @Id
    private Long orderId;
    private Date orderData;
    private long orderPrice;
    private int orderQuantity;
    private Boolean orderCancel;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToMany
    @JoinColumn(name = "id_book")
    private Set<BookEntity> bookEntities;



}
