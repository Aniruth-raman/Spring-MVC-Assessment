package com.spring.mvc.service;

import com.spring.mvc.database.BooksDatabase;
import com.spring.mvc.database.UsersDatabase;
import com.spring.mvc.entity.Books;
import com.spring.mvc.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    @Autowired
    private BooksDatabase bookdb;
    @Autowired
    private UsersDatabase usersdb;

    public List<Books> getAllBooks() {
        List<Books> books = bookdb.getAllBooks();
        return books;
    }

    public Books getBookById(int id) {
        Books book = bookdb.getBookById(id);
        return book;
    }

    public List<Books> getLikedBooks() {
        
//        Users user = usersdb.findByEmail();
        return null;
    }

    public List<Books> getReadLaterBooks() {
        return null;
    }

    public Books findById(int bookId) {
        Books book = bookdb.getBookById(bookId);
        return book;
    }
}