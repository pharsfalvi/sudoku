package com.moc.sudoku.service;

import java.util.Arrays;

public class ValidationException extends RuntimeException {

    public ValidationException(String message, Object... args) {
        super(String.format(message, args));
    }
}
