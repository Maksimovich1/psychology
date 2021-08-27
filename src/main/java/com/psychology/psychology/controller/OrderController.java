package com.psychology.psychology.controller;

import com.psychology.psychology.domain.User;
import com.psychology.psychology.service.SecurityService;
import com.psychology.psychology.service.dto.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andrew.maksimovich
 */
@RestController
@RequestMapping("/v1/order/api")
@RequiredArgsConstructor
public class OrderController {

    private final SecurityService securityService;

    @GetMapping("/create")
    public ResponseEntity<Void> test(){
        UserInfo currentUser = securityService.getCurrentUser();
        return ResponseEntity.ok().build();
    }


}
