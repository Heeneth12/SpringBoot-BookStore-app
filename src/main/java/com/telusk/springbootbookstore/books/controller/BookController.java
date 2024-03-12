package com.telusk.springbootbookstore.books.controller;


import com.telusk.springbootbookstore.books.dto.BookDto;
import com.telusk.springbootbookstore.books.entity.BookEntity;
import com.telusk.springbootbookstore.books.service.IBooksStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@CrossOrigin("http://localhost:3000")
public class BookController {


    @Autowired
    IBooksStore iBooksStore;

    @GetMapping("/api/getBooks")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getAllEmploy(){
        return iBooksStore.getAllBooks();
    }
    @RequestMapping(value = "/api/setBook",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public  List<BookDto> setBook(@RequestBody BookEntity bookEntity){
        return iBooksStore.addBooks(bookEntity);

    }


    @GetMapping("/api/getById/{id}")
    public List<BookDto> getBookById(@PathVariable Long id ){
        return iBooksStore.getBookById(id);
    }

    @DeleteMapping("/api/deleteById/{id}")
    public String deleteBookById( @PathVariable Long id){
        return  iBooksStore.deleteById(id);

    }


}
