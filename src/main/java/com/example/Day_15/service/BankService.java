package com.example.Day_15.service;

import com.example.Day_15.entity.User;
import com.example.Day_15.repository.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class BankService {
    @Autowired
    BankRepo bankRepo;

    public List<User> getAllUsers() {
        return bankRepo.findAll();
    }

    public User AddUser(User user) {
        return bankRepo.save(user);
    }
    public User getUserById(int id) {
        return bankRepo.findById(id).orElse(null); // Returns user or null if not found
    }
}
