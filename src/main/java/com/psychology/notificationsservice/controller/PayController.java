package com.psychology.notificationsservice.controller;

import com.psychology.notificationsservice.controller.dto.request.PayRequestBuyDto;
import com.psychology.notificationsservice.controller.dto.request.PayRequestSubscribeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для проведения оплаты, оформлении подписки
 *
 * @author andrew.maksimovich
 */
@RestController
@RequestMapping("/v1/payment/api")
public class PayController {

    @PostMapping("subscribe")
    public ResponseEntity<Object> subscribe(@RequestBody PayRequestSubscribeDto payRequestSubscribeDto) {
        //TODO нужно это релазовать
        return new ResponseEntity<Object>(HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    @PostMapping("cancel-subscribe")
    public ResponseEntity<Object> subscribeCancel(@RequestBody PayRequestSubscribeDto payRequestSubscribeDto) {
        //TODO нужно это релазовать
        return new ResponseEntity<Object>(HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    @PostMapping("buy")
    public ResponseEntity<Object> buy(@RequestBody PayRequestBuyDto payRequestBuyDto) {
        //TODO нужно это релазовать
        return new ResponseEntity<Object>(HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }
}
