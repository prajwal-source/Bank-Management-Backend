package com.example.Day_15.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private int aadhar;
    private String adress;
    private String email;
    private int age;
    private String phone;
    private String password;


}
