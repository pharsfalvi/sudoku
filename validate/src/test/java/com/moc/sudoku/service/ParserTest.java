package com.moc.sudoku.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParserTest {

    private transient Parser parser;

    @BeforeEach
    void setup() {
        this.parser = new Parser();
    }

    @Test
    void givenAnInputFile_whenLoaded_thenItIsParsed() {
        List<String[]> lines = this.parser.load("src/test/resources/inputFile.txt");
        assertEquals(Arrays.asList(lines.get(0)),
                Arrays.asList(new String[]{"5", "3", "4", "6", "7", "8", "9", "1", "2"}),
                "Thw first rows do not match.");
    }

    @Test
    void givenAnInputFile_whenNotExists_thenExceptionThrown() {
        assertThrows(ValidationException.class, () -> this.parser.load("src/test/resources/dummyyyy.csv")
                , "Invalid file swallowed");
    }

    @Test
    void givenAnInputFile_whenIsDirectory_thenExceptionThrown() {
        assertThrows(ValidationException.class, () -> this.parser.load("src/test/resources")
                , "Directory swallowed");

    }

    @Test
    void givenAnInputFile_whenHasTooManyColumns_thenExceptionThrown() {
        assertThrows(ValidationException.class, () -> this.parser.load("src/test/resources/inputFile1.txt")
                , "Too long line swallowed");

    }

    @Test
    void givenAnInputFile_whenHasTooFewColumns_thenExceptionThrown() {
        assertThrows(ValidationException.class, () -> this.parser.load("src/test/resources/inputFile2.txt")
                , "Too short line swallowed");

    }

    @Test
    void givenAnInputFile_whenItIsTooLong_thenExceptionThrown() {
        assertThrows(ValidationException.class, () -> this.parser.load("src/test/resources/inputFile3.txt")
                , "Too short line swallowed");

    }

    @Test
    void givenAnInputFile_whenItIsTooShort_thenExceptionThrown() {
        assertThrows(ValidationException.class, () -> this.parser.load("src/test/resources/inputFile4.txt")
                , "Too short line swallowed");

    }

    @Test
    void givenAnInputFile_whenBlank_andOnLinux_thenExceptionThrown() {
        System.setProperty("os.name", "linux");
        assertThrows(ValidationException.class, () -> this.parser.load("")
                , "Blank filename swallowed");

    }

    @Test
    void givenAnInputFile_whenBlank_andOnWin_thenExceptionThrown() {
        System.setProperty("os.name", "windows");
        assertThrows(ValidationException.class, () -> this.parser.load("")
                , "Blank filename swallowed");

    }

}