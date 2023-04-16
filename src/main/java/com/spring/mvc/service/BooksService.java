package com.spring.mvc.service;

import com.spring.mvc.database.BooksDatabase;
import com.spring.mvc.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    @Autowired
    private BooksDatabase bookdb;


    public List<Books> getAllBooks() {
        List<Books> books = bookdb.getAllBooks();
        return books;
    }

    public Books getBookById(int id) {
        Books book = bookdb.getBookById(id);
        return book;
    }
}