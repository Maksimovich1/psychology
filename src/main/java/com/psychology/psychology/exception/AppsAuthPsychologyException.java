package com.psychology.psychology.exception;

import lombok.NonNull;

import java.util.function.Supplier;

/**
 * @author andrew.maksimovich
 */
public class AppsAuthPsychologyException extends AppsPsychologyRuntimeException {

    public AppsAuthPsychologyException(@NonNull Supplier<String> messageDetail) {
        super(messageDetail);
    }

    public AppsAuthPsychologyException() {
        super(() -> "Не верный логин или пароль!");
    }
}
