package com.rei.hue.repository;

import com.rei.hue.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    Boolean existsByIsbn(String isbn);
}