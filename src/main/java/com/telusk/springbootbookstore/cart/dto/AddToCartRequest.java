package com.telusk.springbootbookstore.cart.dto;

import com.telusk.springbootbookstore.books.entity.BookEntity;
import com.telusk.springbootbookstore.user.entity.UserEntity;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddToCartRequest {
    private long userId;
    private long bookId;
    private long quantity;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}

