package com.psychology.notificationsservice.controller;

import com.psychology.notificationsservice.controller.dto.request.NotificationRequestDto;
import com.psychology.notificationsservice.service.impl.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andrew.maksimovich
 */
@RestController
@RequestMapping("/v1/notification/api")
public class NotificationController {

    @Autowired
    public MailSenderService emailSender; // TODO посмотри почему ты здесь используешь MailSenderService а не Sending

    @PostMapping("/send")
    public ResponseEntity<Void> send(@RequestBody NotificationRequestDto requestDto) {
        emailSender.sendMessages(requestDto.getEmail(), requestDto.getTextMail(), requestDto.getSubject());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
