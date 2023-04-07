package com.aniruth.bookess.dao;

import com.aniruth.bookess.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {
    public List<Book> findByUsername(String username) {
        return null;
    }

    public List<Book> findAll() {


        return null;
    }

    public void save(Book book) {
    }
}

