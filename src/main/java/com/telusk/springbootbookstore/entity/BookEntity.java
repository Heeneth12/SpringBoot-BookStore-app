package com.telusk.springbootbookstore.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class BookEntity {
    @Id
    @GeneratedValue()
    public Long bookId;
    public String bookName;
    public String bookAuthor;

    public Integer bookPrize;

    public BookEntity(Long bookId, String bookName, String bookAuthor, Integer bookPrize) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrize = bookPrize;
    }
    public BookEntity() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Integer getBookPrize() {
        return bookPrize;
    }

    public void setBookPrize(Integer bookPrize) {
        this.bookPrize = bookPrize;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrize=" + bookPrize +
                '}';
    }
}
