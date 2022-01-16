package com.moc.sudoku.service;

import com.moc.sudoku.data.Grid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {

    private transient Validator validator;
    private transient Grid grid;
    private transient Grid grid1;
    private transient Grid grid2;

    private final transient List<String> solution = List.of("5,3,4,6,7,8,9,1,2",
            "6,7,2,1,9,5,3,4,8",
            "1,9,8,3,4,2,5,6,7",
            "8,5,9,7,6,1,4,2,3",
            "4,2,6,8,5,3,7,9,1",
            "7,1,3,9,2,4,8,5,6",
            "9,6,1,5,3,7,2,8,4",
            "2,8,7,4,1,9,6,3,5",
            "3,4,5,2,8,6,1,7,9");

    private final transient List<String> solution1 = List.of("5,3,4,6,7,8,9,1,2",
            "6,7,2,1,9,5,3,4,8",
            "1,9,8,3,4,2,5,6,7",
            "8,5,9,7,6,1,4,2,3",
            "4,2,6,8,5,3,7,9", // missing value in row
            "7,1,3,9,2,4,8,5,6",
            "9,6,1,5,3,7,2,8,4",
            "2,8,7,4,1,9,6,3,5",
            "3,4,5,2,8,6,1,7,9");

    private final transient List<String> solution2 = List.of("5,3,4,6,7,8,9,1,2",
            "6,7,2,1,9,5,3,4,8",
            "1,9,8,3,4,2,5,6,7",
            "8,5,9,7,6,1,4,2,3",
            "4,2,6,8,5,3,7,9,9", // duplicate value in row
            "7,1,3,9,2,4,8,5,6",
            "9,6,1,5,3,7,2,8,4",
            "2,8,7,4,1,9,6,3,5",
            "3,4,5,2,8,6,1,7,9");


    @BeforeEach
    void setup() {
        this.validator = new Validator();
        this.grid = fillGrid(solution);
        this.grid1 = fillGrid(solution1);
        this.grid2 = fillGrid(solution2);
    }

    @Test
    void givenGrid_withEmptyCell_thenThrowsValidationError() {
        assertThrows(ValidationException.class, () -> validator.validate(new Grid()), "A grid vith empty cell must throw validation exception");
    }

    @Test
    void givenSudoku_whenSolutionProvided_thenValidatorCompletes() {
        validator.validate(grid);
        assertSame(1, 1, "Validation failed");
    }

    @Test
    void givenSudoku_whenEmptyCell_thenValidatorCompletes() {
        assertThrows(ValidationException.class, () -> validator.validate(grid1), "A grid vith one empty cell");
    }

    @Test
    void givenSudoku_whenDuplicateCell_thenValidatorCompletes() {
        assertThrows(ValidationException.class, () -> validator.validate(grid2), "A grid vith a duplicate cell");
    }


    private Grid fillGrid(List<String> solution) {
        Grid result = new Grid();
        for (int row = 0; row < solution.size(); row++) {
            String[] cells = solution.get(row).split(","); // NOPMD
            for (int column = 0; column < cells.length; column++) {
                result.getCell(row, column).setValue(Integer.valueOf(cells[column]));
            }
        }
        return result;
    }
}