package com.spring.mvc.database;

import com.spring.mvc.entity.Books;
import com.spring.mvc.entity.UserBook;
import com.spring.mvc.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserBookDatabase {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Books> getFavorites(Users user) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT ub.bookId FROM UserBook ub WHERE ub.userId = :user AND ub.liked = true";
            Query query = session.createQuery(hql);
            query.setParameter("user", user);
            List<Books> favorites = query.list();
            return favorites;
        }
    }

    public void setFavorites(Users user, List<Books> favorites) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            // First, remove all existing favorites for the user
            String deleteHql = "DELETE FROM UserBook ub WHERE ub.userId = :user AND ub.liked = true";
            Query deleteQuery = session.createQuery(deleteHql);
            deleteQuery.setParameter("user", user);
            deleteQuery.executeUpdate();
            // Then, add the new favorites
            for (Books book : favorites) {
                UserBook userBook = new UserBook();
                userBook.setUserId(user);
                userBook.setBookId(book);
                userBook.setLiked(true);
                session.save(userBook);
            }
            tx.commit();
        }
    }

    public List<Books> getReadLater(Users user) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT ub.bookId FROM UserBook ub WHERE ub.userId = :user AND ub.readLater = true";
            Query query = session.createQuery(hql);
            query.setParameter("user", user);
            List<Books> readLater = query.list();
            return readLater;
        }
    }

    public void setReadLater(Users user, List<Books> readLater) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            // First, remove all existing books in read later list for the user
            String deleteHql = "DELETE FROM UserBook ub WHERE ub.userId = :user AND ub.readLater = true";
            Query deleteQuery = session.createQuery(deleteHql);
            deleteQuery.setParameter("user", user);
            deleteQuery.executeUpdate();
            // Then, add the new books in read later list
            for (Books book : readLater) {
                UserBook userBook = new UserBook();
                userBook.setUserId(user);
                userBook.setBookId(book);
                userBook.setReadLater(true);
                session.save(userBook);
            }
            tx.commit();
        }
    }
}