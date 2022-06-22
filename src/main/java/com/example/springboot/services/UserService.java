package com.example.springboot.services;

import com.example.springboot.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User createUser(User user) {
        return new User(
                user.getId(),
                user.getName(),
                user.getUsername()
        );
    }

    public void editUser(User user, long id, String name, String username) {
                user.setId(id);
                user.setName(name);
                user.setUsername(username);
    }
}
