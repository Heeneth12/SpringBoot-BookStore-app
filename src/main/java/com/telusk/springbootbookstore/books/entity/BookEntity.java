package com.telusk.springbootbookstore.books.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import javax.mail.Multipart;


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

    public BookEntity(Long bookId, String bookName, String bookAuthor, Integer bookPrize, Integer bookQuantity ,String bookLogo ) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrize = bookPrize;
        this.bookQuantity = bookQuantity;
        this.bookLogo = bookLogo;
    }

    public BookEntity() {

    }

}
