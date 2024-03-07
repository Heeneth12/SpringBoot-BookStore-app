package com.telusk.springbootbookstore.books.service;
import com.telusk.springbootbookstore.books.dto.BookDto;
import com.telusk.springbootbookstore.books.entity.BookEntity;
import com.telusk.springbootbookstore.books.repository.BooksRepo;
import com.telusk.springbootbookstore.books.service.IBooksStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class BookStoreImpl implements IBooksStore {


    @Autowired
    BooksRepo booksRepo;

    public List<BookDto> getAllBooks(){
        return booksRepo.findAll()
                .stream()
                .map(bookEntity -> new BookDto(
                        bookEntity.getBookId(),
                        bookEntity.getBookName(),
                        bookEntity.getBookAuthor(),
                        bookEntity.getBookPrize()
                )).collect(Collectors.toList());
    }

     public  List<BookDto> addBooks( BookEntity bookEntity){
        booksRepo.save(bookEntity);
        return getAllBooks();
    }

    public List<BookDto> getBookById(Long id){
       return booksRepo.findById(id)
               .stream()
               .map(bookEntity -> new BookDto(
                       bookEntity.getBookId(),
                       bookEntity.getBookName(),
                       bookEntity.getBookAuthor(),
                       bookEntity.getBookPrize()
               )).collect(Collectors.toList());
    }

    public String deleteById(Long id ){
        if(booksRepo.existsById(id)){
            booksRepo.deleteById(id);

            return "Deleted book Successfully";
        }
        else {
            return "Id not Existed";
        }

    }


}
