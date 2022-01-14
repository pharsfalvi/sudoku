package com.moc.sudoku;


import static org.junit.jupiter.api.Assertions.*;

import com.moc.sudoku.service.ValidationException;
import org.junit.jupiter.api.Test;

public class ValidationExceptionTest {

    @Test
    public void givenMessageParameter_whenNotProvided_exceptionIsProduced(){
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            throw new ValidationException("Message");
        });
        assertEquals("Message", exception.getMessage());
    }

    @Test
    public void givenMessageParameter_whenProvided_exceptionIsProducedAndMessageIsCorrect(){
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            throw new ValidationException("Message with %s", "Parameter");
        });
        assertEquals("Message with Parameter", exception.getMessage());
    }
}
