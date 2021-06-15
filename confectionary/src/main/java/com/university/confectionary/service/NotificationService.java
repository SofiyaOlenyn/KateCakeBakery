package com.university.confectionary.service;

import com.university.confectionary.domain.entities.ProductEntity;
import com.university.confectionary.dto.OrderDto;
import com.university.confectionary.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final JavaMailSender javaMailSender;

    public void sendEmail(OrderDto orderDto) throws MailException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(orderDto.getEmail());
        simpleMailMessage.setFrom("katecakebakerycompany@gmail.com");
        simpleMailMessage.setSubject("Подтверждение заказа от KateCake website");
        simpleMailMessage.setText("Уважаемая (-ый) "+orderDto.getName()+" "+orderDto.getSurname()+"!\n" +
                "Мы искренне благодарны, что Вы решили заказать продукцию KateCakeBakery! Надеемся, у Вас не возникло вопросов / проблем при создании заказа. В противном случае - ждите звонок-подтверждение заказа от нашего администратора для уточнения всех деталей и решения всех имеющихся вопросов.\n" +
                "С уважением,\n" +
                "команда KateCakeBakery :)");
        javaMailSender.send(simpleMailMessage);
    }
}
