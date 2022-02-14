package com.rei.hue.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.rei.hue.model.Book;
import com.rei.hue.controller.form.BookForm;
import com.rei.hue.repository.BookRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class BookService {
	@Autowired
	BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Integer id) {
        return bookRepository.getById(id);
    }

    public Boolean existsByIsbn(String isbn) {
        return bookRepository.existsByIsbn(isbn);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

    public void create(BookForm form) {
        Book book = new Book();
		book.setId(form.getId());
		book.setName(form.getName());
		book.setIsbn(form.getIsbn());
		book.setDescription(form.getDescription());
		book.setPublisher(form.getPublisher());
		book.setPrice(form.getPrice());
		book.setPublication_date(form.getPublication_date());
		book.setVersion(form.getVersion());
        bookRepository.save(book);
    }
}