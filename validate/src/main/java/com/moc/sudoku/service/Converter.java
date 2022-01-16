package com.moc.sudoku.service;

import com.moc.sudoku.data.Grid;

import java.util.List;

import static com.moc.sudoku.data.Grid.GRID_SIZE;

/**
 * Converts a List of String arrays to a Grid object.
 */
public class Converter {

    /**
     * Converts the input to a Grid object.
     *
     * @param lines a List of String arrays
     * @return a Grid containing the int values of the input.
     * @throws ValidationException - in case any String value cannot be converted to a Grid Cell value.
     */
    public Grid loadLines(List<String[]> lines) {
        Grid grid = new Grid();
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                try {
                    String val = lines.get(row)[col].trim();
                    grid.getCell(row, col).setValue(Integer.parseInt(val));
                } catch (ValidationException e) {
                    throw e;
                } catch (Exception e) {
                    throw new ValidationException("Error parsing value at row: %d column: %d", e, row + 1, col + 1);
                }
            }
        }
        return grid;
    }
}
