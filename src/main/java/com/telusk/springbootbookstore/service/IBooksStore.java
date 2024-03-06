package com.telusk.springbootbookstore.service;

import com.telusk.springbootbookstore.entity.BookEntity;

import java.util.List;
import java.util.Optional;

public interface IBooksStore {

    List<BookEntity> getAllBooks();

    List<BookEntity> addBooks( BookEntity bookEntity);
    Optional<BookEntity> getBookById(Long id);
    String deleteById(Long id );
 }
