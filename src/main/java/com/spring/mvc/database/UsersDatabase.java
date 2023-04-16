package com.spring.mvc.database;

import com.spring.mvc.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class UsersDatabase {

    @Autowired
    private SessionFactory factory;

//    public List<Users> getAllUsers() {
//        Session session = factory.openSession();
//        List<Users> users = session.createQuery("from Users", Users.class).getResultList();
//        session.close();
//        return users;
//    }

    public boolean loginUser(Users dto) throws Exception {
        // Retrieve the user from the database using the provided email
        Session session = factory.openSession();
        System.out.println("DTO" + dto);
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Users> criteria = builder.createQuery(Users.class);
        Root<Users> root = criteria.from(Users.class);
        criteria.select(root).where(builder.equal(root.get("email"), dto.getEmail()));
        Users user = session.createQuery(criteria).uniqueResult();
        System.out.println("User:" + user);
        session.close();
        System.out.println("Result:" + user != null && user.getPassword().equals(dto.getPassword()));
        return user != null && user.getPassword().equals(dto.getPassword());
    }

    public Users findByUsername(String username) {
        try (Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Users> criteria = builder.createQuery(Users.class);
            Root<Users> root = criteria.from(Users.class);
            criteria.select(root).where(builder.equal(root.get("username"), username));
            return session.createQuery(criteria).uniqueResult();
        } catch (Exception e) {
            System.out.println("Exception block for findByUsername");
        }
        return null;
    }

    public Users findByEmail(String email) {
        try (Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Users> criteria = builder.createQuery(Users.class);
            Root<Users> root = criteria.from(Users.class);
            criteria.select(root).where(builder.equal(root.get("email"), email));
            return session.createQuery(criteria).uniqueResult();
        } catch (Exception e) {
            System.out.println("Exception block for findByUsername");
        }
        return null;
    }

    public void registerUser(Users user) {
        System.out.println(user);
        Session session = factory.openSession();
        // Begin a transaction
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
    }
}
