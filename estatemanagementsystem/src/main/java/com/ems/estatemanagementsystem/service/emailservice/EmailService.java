package com.ems.estatemanagementsystem.service.emailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("muhammadrizdwan@graduate.utm.my");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        emailSender.send(message);

        System.out.println("Email sent successfully!");

        // String confirmationLink = "http://your-email-service.com/sent-emails/" + System.currentTimeMillis();
    }
}
