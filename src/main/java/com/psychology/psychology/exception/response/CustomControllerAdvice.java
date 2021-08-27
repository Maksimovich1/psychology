package com.psychology.psychology.exception.response;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author andrew.maksimovich
 */
@ControllerAdvice
@RequiredArgsConstructor
@Log4j2
public class CustomControllerAdvice {

    private final ExceptionHandler exceptionHandler;

}
