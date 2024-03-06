package com.telusk.springbootbookstore.controler;


import com.telusk.springbootbookstore.entity.BookEntity;
import com.telusk.springbootbookstore.service.IBooksStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
public class BookStoreControler {


    @Autowired
    IBooksStore iBooksStore;

    @GetMapping("/api/getBooks")
    @ResponseStatus(HttpStatus.OK)
    public List<BookEntity> getAllEmploy(){
        return iBooksStore.getAllBooks();
    }
    @RequestMapping(value = "/api/setBook")
    public  List<BookEntity> setBook(@RequestBody BookEntity bookEntity){
        return iBooksStore.addBooks(bookEntity);

    }
    @GetMapping("/api/getById/{id}")
    public Optional<BookEntity> getBookById(@PathVariable Long id ){
        return iBooksStore.getBookById(id);
    }

    @DeleteMapping("/api/deleteById/{id}")
    public String deleteBookById( @PathVariable Long id){
         return  iBooksStore.deleteById(id);

    }
}
