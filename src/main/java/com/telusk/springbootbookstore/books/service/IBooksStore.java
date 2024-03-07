package com.telusk.springbootbookstore.books.service;

import com.telusk.springbootbookstore.books.dto.BookDto;
import com.telusk.springbootbookstore.books.entity.BookEntity;

import java.util.List;
import java.util.Optional;

public interface IBooksStore {

    List<BookDto> getAllBooks();

    List<BookDto> addBooks( BookEntity bookEntity);
    List<BookDto> getBookById(Long id);
    String deleteById(Long id );


 }
