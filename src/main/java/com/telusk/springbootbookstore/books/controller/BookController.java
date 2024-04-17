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
@CrossOrigin("http://localhost:4200")
public class BookController {


    @Autowired
    IBooksStore iBooksStore;

    @GetMapping("/getAllBooks")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getAllEmploy(){
        return iBooksStore.getAllBooks();
    }

    @RequestMapping(value = "/setBook",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public  List<BookDto> setBook(@RequestBody BookEntity bookEntity){
        return iBooksStore.addBooks(bookEntity);

    }


    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getBookById(@PathVariable Long id ){
        return iBooksStore.getBookById(id);
    }


    @PutMapping("editBook/byId/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String editBookById( @PathVariable Long id ,@RequestBody BookEntity bookEntity){
        return iBooksStore.editBookById(id , bookEntity);
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteBookById( @PathVariable Long id){
        return  iBooksStore.deleteById(id);

    }


    //change book  quantity by user id and token , new quantity
    @PutMapping("/changeBook/quantity")
    public  String changeBookQuantityBy( ){
        return "Successfully added quantity";
    }



}
