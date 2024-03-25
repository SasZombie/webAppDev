package org.example.lab2.services;

import org.example.lab2.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User u);
}
