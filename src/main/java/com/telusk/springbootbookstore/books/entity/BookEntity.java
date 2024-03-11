package com.telusk.springbootbookstore.books.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


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

    @Override
    public String toString() {
        return "BookEntity{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrize=" + bookPrize +
                ", bookQuantity=" + bookQuantity +
                '}';
    }

    public BookEntity(Long bookId, String bookName, String bookAuthor, Integer bookPrize, Integer bookQuantity) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrize = bookPrize;
        this.bookQuantity = bookQuantity;
    }

    public BookEntity() {

    }

}
