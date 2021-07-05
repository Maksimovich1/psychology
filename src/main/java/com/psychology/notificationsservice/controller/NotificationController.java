package com.psychology.notificationsservice.controller;

import com.psychology.notificationsservice.controller.dto.response.NotificationResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andrew.maksimovich
 */
@RestController
@RequestMapping("/v1/notification/api")
public class NotificationController {
    //
    @PostMapping("/send")
    public ResponseEntity<NotificationResponseDto> send() {
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
