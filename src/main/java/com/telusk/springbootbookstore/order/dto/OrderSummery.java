package com.telusk.springbootbookstore.order.dto;

import com.telusk.springbootbookstore.user.entity.UserEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import java.util.Date;


@Data
public class OrderSummery {
    private Long orderId;
    private Date orderData;
    private int orderPrice;
    private int orderQuantity;
    private Boolean orderCancel;
    private Long userID;
    private Long cartID;
    private Boolean cartOrderedBoolean;
}
