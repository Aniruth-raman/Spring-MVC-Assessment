package com.spring.mvc.database;

import com.spring.mvc.entity.Books;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BooksDatabase {
    SessionFactory factory;
    public List<Books> getAllBooks() {
        Session session = factory.openSession();
        List<Books> books = session.createQuery("from Books", Books.class).getResultList();
        session.close();
        return books;
    }

    public Books getBookById(int id) {
        Session session = factory.openSession();
        Books book = session.get(Books.class, id);
        session.close();
        return book;
    }
}
