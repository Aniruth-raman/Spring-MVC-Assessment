package com.spring.mvc.service;

import com.spring.mvc.database.UsersDatabase;
import com.spring.mvc.dto.LoginDTO;
import com.spring.mvc.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersDatabase database;

    public boolean validateUser(Users user) throws Exception {
        return this.database.loginUser(user);
    }

    public Users findByUsername(String username) {
        return this.database.findByUsername(username);
    }

    public void registerUser(Users user) throws Exception {
        try {
            this.database.registerUser(user);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
