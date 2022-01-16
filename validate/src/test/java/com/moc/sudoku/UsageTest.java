/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.moc.sudoku;

import com.moc.sudoku.service.Parser;
import com.moc.sudoku.service.ValidationException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UsageTest {


    private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final static PrintStream originalOut = System.out;


    @BeforeAll
    static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    static void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    void givenNoSolutionFileProvided_thenValidationExceptionThrownWithUsage() {
        try {
            new Parser().load("");
        } catch (ValidationException e) {
            System.out.println(e.getMessage()); // NOPMD
        }
        assertTrue(outContent.toString().contains("Usage:"), "app should print Usage in case no solution file provided");
    }
}
