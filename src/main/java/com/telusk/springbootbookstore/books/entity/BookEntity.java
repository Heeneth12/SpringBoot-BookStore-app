package com.telusk.springbootbookstore.books.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telusk.springbootbookstore.cart.entity.CartEntity;
import com.telusk.springbootbookstore.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class BookEntity {
    @Id
    @GeneratedValue()
    public Long bookId;
    public String bookName;
    public String bookDescription;
    public String bookAuthor;
    public Integer bookPrize;
    public Integer bookQuantity;
    public String bookLogo;

    //BookEntity - CartEntity: A cart can contain multiple books. This is also a @OneToMany relationship.
    @OneToMany(mappedBy = "bookEntity")
    @JsonIgnore
    private List<CartEntity> carts;

    public BookEntity(Long bookId, String bookName, String bookDescription, String bookAuthor, Integer bookPrize, Integer bookQuantity, String bookLogo, List<CartEntity> carts) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.bookAuthor = bookAuthor;
        this.bookPrize = bookPrize;
        this.bookQuantity = bookQuantity;
        this.bookLogo = bookLogo;
        this.carts = carts;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrize=" + bookPrize +
                ", bookQuantity=" + bookQuantity +
                ", bookLogo='" + bookLogo + '\'' +
                '}';
    }
    public BookEntity() {

    }
}
