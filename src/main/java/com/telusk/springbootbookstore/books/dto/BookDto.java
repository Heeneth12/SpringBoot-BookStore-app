package com.telusk.springbootbookstore.books.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    public Long bookId;
    public String bookName;
    public String bookAuthor;
    public Integer bookPrize;
    public String bookLogo;
    public String bookDescription;


    @Override
    public String toString() {
        return "BookDto{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrize=" + bookPrize +
                ", bookLogo='" + bookLogo + '\'' +
                '}';
    }
}
