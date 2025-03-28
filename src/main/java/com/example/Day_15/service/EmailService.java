package com.example.Day_15.service;

import com.example.Day_15.entity.UserMail;
import com.example.Day_15.repository.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class EmailService {


    @Autowired
    private JavaMailSender mailSender;

    public void sendRegistrationEmail(String toEmail, String username, int otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Welcome to Our Platform!");
        message.setText("Hello " + username + ",\n\nThank you for registering with us!\n\nBest Regards,\nYour Company \n your otp is "+otp);

        mailSender.send(message);
    }

}
