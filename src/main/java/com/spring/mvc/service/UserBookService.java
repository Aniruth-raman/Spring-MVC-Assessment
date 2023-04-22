package com.spring.mvc.service;

import com.spring.mvc.database.UserBookDatabase;
import com.spring.mvc.entity.Books;
import com.spring.mvc.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBookService {
    @Autowired
    UserBookDatabase userBookDatabase;

    public void addToFavorites(Users user, Books book) {
        // Get the user's list of favorite books
        List<Books> favorites = userBookDatabase.getFavorites(user);

        // If the book is not already in the user's list of favorites, add it
        if (!favorites.contains(book)) {
            favorites.add(book);
            userBookDatabase.setFavorites(user, favorites);
        }
    }

    public void addToReadLater(Users user, Books book) {
        // Get the user's list of books to read later
        List<Books> readLater = userBookDatabase.getReadLater(user);

        // If the book is not already in the user's list of books to read later, add it
        if (!readLater.contains(book)) {
            readLater.add(book);
            userBookDatabase.setReadLater(user, readLater);
        }
    }

    public void removeFromFavorites(Users user, Books book) {
        // Get the user's list of favorite books
        List<Books> favorites = userBookDatabase.getFavorites(user);

        // If the book is in the user's list of favorites, remove it
        if (favorites.contains(book)) {
            favorites.remove(book);
            userBookDatabase.setFavorites(user, favorites);
        }
    }

    public void removeFromReadLater(Users user, Books book) {
        // Get the user's list of books to read later
        List<Books> readLater = userBookDatabase.getReadLater(user);

        // If the book is in the user's list of books to read later, remove it
        if (readLater.contains(book)) {
            readLater.remove(book);
            userBookDatabase.setReadLater(user, readLater);
        }
    }

    public List<Books> getReadLater(Users user) {
        return userBookDatabase.getReadLater(user);
    }

    public List<Books> getFavorites(Users user) {
        return userBookDatabase.getFavorites(user);
    }
}
