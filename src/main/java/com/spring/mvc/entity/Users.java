package com.spring.mvc.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String username;

    private String password;

    public Users() {
        // TODO Auto-generated constructor stub
    }

    public Users(String username, String email, String password) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", email='" + email + '\'' + ", username='" + username + '\'' + ", password='" + password + '\'' + '}';
    }

    public int getId() {
        return id;
    }

    public void setFavorites(List<Books> favorites) {
    }
}
