package com.psychology.notificationsservice.controller;

import com.psychology.notificationsservice.controller.dto.request.NotificationRequestDto;
import com.psychology.notificationsservice.controller.dto.response.NotificationResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

/**
 * @author andrew.maksimovich
 */
@RestController
@RequestMapping("/v1/notification/api")
public class NotificationController {
    public static final String FRIEND_EMAIL = "maksvv.m@yandex.by";

    @Autowired
    public JavaMailSender emailSender;
    //
    @GetMapping ("/send")
    public ResponseEntity<NotificationResponseDto> send() {
        NotificationRequestDto notificationRequestDto = new NotificationRequestDto();
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(notificationRequestDto.getEmailAddress());
        message.setSubject("Test Simple Email");
        message.setText("Hello, Im testing Simple Email");

        // Send Message!
        this.emailSender.send(message);

        //TODO реализовать
        // метод должен принимать объект NotificationRequestDto который должен содержать (почту на которую будет отправка и само сообщение(пока просто строка))
        // здесь нужно вызвать сервис который и будет собственно выполнять работу по отправке на почту уведомлений
        // сервис должен имплементить интерфейс
        // для сервиса ножен новый пакет
        // интерфейс должен содержать один метод по отправке нотификаций
        // посмотреть настройку для отправки на емайл, сконфигурировать и попробовать сделать отправку, по пути может понадобится почта
        // gmail можно пока заюзать свою
        // пока реализовать просто отправку строки по почте
        return ResponseEntity.ok(new NotificationResponseDto());
    }
}
