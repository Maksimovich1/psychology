package com.psychology.psychology.controller;

import com.psychology.psychology.controller.dto.request.NotificationRequestDto;
import com.psychology.psychology.service.Sending;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер по работе с уведомлениями
 *
 * @author andrew.maksimovich
 */
@RestController
@RequestMapping("/v1/notification/api")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class NotificationController {

    public final Sending emailSender;

    /**
     * Отправка нотификации
     *
     * @param requestDto объект содержищий информацию о деталях отправки
     * @return пока ничего, думаю и не нужно ничего
     */
    @PostMapping("/send")
    public ResponseEntity<Void> send(@RequestBody NotificationRequestDto requestDto) {
        emailSender.sendMessages(requestDto.getEmail(), requestDto.getTextMail(), requestDto.getSubject());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
