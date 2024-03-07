package com.telusk.springbootbookstore.books.repository;

import com.telusk.springbootbookstore.books.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepo extends JpaRepository<BookEntity,Long> {
}
