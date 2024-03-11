package com.telusk.springbootbookstore.order.entity;

import com.telusk.springbootbookstore.user.entity.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;



@Entity
@Setter
@Getter
public class OrderEntity {

    @Id
    private Long orderId;
    private Date orderData;
    private long orderPrice;

//    private UserEntity userEntity;

    private Boolean  OrderCancel;

    public OrderEntity(){

    }

    public OrderEntity(Long orderId, Date orderData, long orderPrice, Boolean orderCancel) {
        this.orderId = orderId;
        this.orderData = orderData;
        this.orderPrice = orderPrice;
        OrderCancel = orderCancel;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderId=" + orderId +
                ", orderData=" + orderData +
                ", orderPrice=" + orderPrice +
                ", OrderCancel=" + OrderCancel +
                '}';
    }
}
