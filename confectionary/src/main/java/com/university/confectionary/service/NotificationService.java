package com.university.confectionary.service;


import com.university.confectionary.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(OrderDto orderDto) throws MailException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(orderDto.getEmail());
        simpleMailMessage.setFrom("katecakebakerycompany@gmail.com");
        simpleMailMessage.setSubject("Confirmation of the created order at KateCake website");
        simpleMailMessage.setText("Test text ");
        System.out.println("mess");
        System.out.println(simpleMailMessage);
        javaMailSender.send(simpleMailMessage);
    }
}
