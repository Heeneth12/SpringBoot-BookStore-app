package com.telusk.springbootbookstore.repository;

import com.telusk.springbootbookstore.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepo extends JpaRepository<BookEntity,Long> {
}
