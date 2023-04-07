package com.aniruth.bookess.service;

import com.aniruth.bookess.dao.BookRepository;
import com.aniruth.bookess.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getMyBooks(String username) {
        return bookRepository.findByUsername(username);
    }

    public void addBook(Book book, String username) {
        book.setUsername(username);
        bookRepository.save(book);
    }
}

