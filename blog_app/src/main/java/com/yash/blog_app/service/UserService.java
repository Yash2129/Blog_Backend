package com.yash.blog_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.blog_app.entity.Users;
import com.yash.blog_app.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users registerUser(Users user) {
        return userRepository.save(user);
    }

    public Users findByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    
}
