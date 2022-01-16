package com.moc.sudoku.service;

import com.moc.sudoku.data.Grid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConverterTest {


    private transient Converter converter;
    private transient List<String[]> lines;
    private transient Grid grid;

    @BeforeEach
    void setup() {
        this.converter = new Converter();
        this.grid = new Grid();
        this.lines = List.of(
                new String[]{"5", "3", "4", "6", "7", "8", "9", "1", "2"},
                new String[]{"6", "7", "2", "1", "9", "5", "3", "4", "8"},
                new String[]{"1", "9", "8", "3", "4", "2", "5", "6", "7"},
                new String[]{"8", "5", "9", "7", "6", "1", "4", "2", "3"},
                new String[]{"4", "2", "6", "8", "5", "3", "7", "9", "1"},
                new String[]{"7", "1", "3", "9", "2", "4", "8", "5", "6"},
                new String[]{"9", "6", "1", "5", "3", "7", "2", "8", "4"},
                new String[]{"2", "8", "7", "4", "1", "9", "6", "3", "5"},
                new String[]{"3", "4", "5", "2", "8", "6", "1", "7", "9"});
    }

    @Test
    void givenLines_whenValidValuesProvided_thenDataProduced() {
        this.grid = this.converter.loadLines(lines);
        assertTrue(this.grid.getCells().stream()
                .filter(cell -> cell.getValue() == 0)
                .collect(Collectors.toList()).isEmpty(), "Not all cells filled.");
    }

    @Test
    void givenLines_whenInvalidNiumberValueProvided_thenExceptionThrown() {
        lines.get(5)[5] = "99";
        assertThrows(ValidationException.class, () -> this.converter.loadLines(lines), "Invalid number at position");
    }


    @Test
    void givenLines_whenNotANiumberValueProvided_thenExceptionThrown() {
        lines.get(5)[5] = "AA";
        assertThrows(ValidationException.class, () -> this.converter.loadLines(lines), "Invalid number at position");
    }
}