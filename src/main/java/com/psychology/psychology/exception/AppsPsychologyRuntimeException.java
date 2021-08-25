package com.psychology.psychology.exception;

import lombok.Getter;
import lombok.NonNull;

import java.util.function.Supplier;

/**
 * Стандартный класс ошибки, содержит базовую информацию
 *
 * @author andrew.maksimovich
 */
@Getter
public class AppsPsychologyRuntimeException extends RuntimeException {

    public AppsPsychologyRuntimeException(@NonNull Supplier<String> messageDetail) {
        this.messageDetail = messageDetail.get();
    }

    public AppsPsychologyRuntimeException(@NonNull Supplier<String> message, Throwable cause, Supplier<String> messageDetail) {
        super(message.get(), cause);
        this.messageDetail = messageDetail.get();
    }

    private final String messageDetail;

}
