package com.moc.sudoku.service;

/**
 * This exception is thrown if the validation fails.
 * It provides a parameterizable error message which is propagated to the caller.
 */
public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = 3596247531687026158L;

    public ValidationException(String message, Object... args) {
        super(String.format(message, args));
    }

    public ValidationException(String message, Throwable cause, Object... args) {
        super(String.format(message, args), cause);
    }
}
