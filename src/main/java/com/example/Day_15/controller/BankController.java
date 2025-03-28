package com.example.Day_15.controller;


import com.example.Day_15.entity.User;
import com.example.Day_15.entity.UserMail;
import com.example.Day_15.service.BankService;
import com.example.Day_15.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController

public class BankController {
 @Autowired
    BankService bankService;
    @Autowired
    private EmailService emailService;
 @GetMapping("/user")

    public ResponseEntity<List<User>> getAllUsers() {
     List<User> users = bankService.getAllUsers();
     return new ResponseEntity<>(users, HttpStatus.OK);

 }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = bankService.getUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

 @PostMapping("/user")
    public ResponseEntity<User> AddUser(@RequestBody User user) {
    try{
            this.bankService.AddUser(user);
        System.out.println(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


 }
 // postmapping for bank
    @PostMapping("/mail")
    public String sendMail(@RequestBody UserMail usermail ) {
        emailService.sendRegistrationEmail(usermail.getEmail(), usermail.getUsername(), usermail.getOtp());

        return "Registration successful! A confirmation email has been sent to " + usermail.getEmail();
    }
      @GetMapping("/mail")
      public String hello(){
       return "Hello World";
       }

}
