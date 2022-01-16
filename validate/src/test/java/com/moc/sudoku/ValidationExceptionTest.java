package com.moc.sudoku;


import com.moc.sudoku.service.ValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidationExceptionTest {

    @Test
    void givenMessageParameter_whenNotProvided_exceptionIsProduced() {
        try {
            throw new ValidationException("Message");
        } catch (ValidationException e) {
            assertEquals("Message", e.getMessage(), "Invalid message returned");
        }
    }

    @Test
    void givenMessageParameter_whenProvided_exceptionIsProducedAndMessageIsCorrect() {
        try {
            throw new ValidationException("Message with %s", "Parameter");
        } catch (ValidationException e) {
            assertEquals("Message with Parameter", e.getMessage(), "Invalid message returned");
        }
    }

    @Test
    void givenMessageParameter_whenCauseIsProvided_thenExceptionIsProducedAndMessageIsCorrect() {
        try {
            throw new ValidationException("Message with %s", new Exception(), "Parameter");
        } catch (ValidationException e) {
            assertEquals("Message with Parameter", e.getMessage(), "Invalid message returned");
        }
    }
}
