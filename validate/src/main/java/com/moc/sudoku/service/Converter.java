package com.moc.sudoku.service;

import com.moc.sudoku.data.Grid;

import java.util.List;

import static com.moc.sudoku.data.Grid.GRID_SIZE;

public class Converter {

    public Grid loadLines(List<String[]> lines) {
        Grid grid = new Grid();
        for (int row = 0; row < GRID_SIZE; row++) {
            String[] line = lines.get(row);
            for (int col = 0; col < GRID_SIZE; col++) {
                try {
                    String val = line[col].trim();
                    grid.getCell(row, col).setValue(Integer.parseInt(val));
                } catch (Exception e) {
                    throw new ValidationException("Error parsing value at row: %d column: %d", row + 1, col + 1);
                }
            }
        }
        return grid;
    }
}
