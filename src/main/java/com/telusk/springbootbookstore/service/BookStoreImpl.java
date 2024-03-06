package com.telusk.springbootbookstore.service;
import com.telusk.springbootbookstore.entity.BookEntity;
import com.telusk.springbootbookstore.repository.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;




@Component
public class BookStoreImpl implements IBooksStore {


    @Autowired
    BooksRepo booksRepo;

    public List<BookEntity> getAllBooks(){
        return booksRepo.findAll();
    }

     public  List<BookEntity> addBooks( BookEntity bookEntity){
        booksRepo.save(bookEntity);
        return getAllBooks();
    }

    public Optional<BookEntity> getBookById(Long id){
//        return booksRepo.findById(id);
        if(booksRepo.existsById(id)){
            return booksRepo.findById(id);
        }
        return booksRepo.findById(id);
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
