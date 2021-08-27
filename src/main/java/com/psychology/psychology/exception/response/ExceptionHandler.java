package com.psychology.psychology.exception.response;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Обработчик который по ошибке выставляет httpcode
 *
 * @author andrew.maksimovich
 */
@Component
public class ExceptionHandler {

    public HttpStatus getStatusByException(Exception e) {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
