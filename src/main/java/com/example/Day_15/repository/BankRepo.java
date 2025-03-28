package com.example.Day_15.repository;

import com.example.Day_15.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BankRepo extends JpaRepository <User,Integer> {

}
