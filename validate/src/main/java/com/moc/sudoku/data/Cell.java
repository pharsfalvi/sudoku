package com.moc.sudoku.data;


import com.moc.sudoku.service.ValidationException;

import static com.moc.sudoku.data.Grid.*;

/**
 * Represents a cell on the Sudoku grid in a given position.
 */
public class Cell {

    private final int row;

    private final int column;

    private int value;

    public Cell(int row, int col) {
        this.row = row;
        this.column = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public int getValue() {
        return value;
    }

    /**
     * Validates and sets the value of this cell.
     *
     * @param value the value. Must be between 1..{@value Grid#GRID_SIZE}
     */
    public void setValue(int value) {
        if (value <= 0 || value > GRID_SIZE) {
            throw new ValidationException("Value %d is out of range [1..%d] at position %s.", value, GRID_SIZE, getCoordinate());
        }
        this.value = value;
    }

    /**
     * Provides the number of the block where this cell is located.
     *
     * @return the number of the block in the range of 0...{@value Grid#GRID_SIZE}-1
     */
    public int getBlockNumber() {
        return BLOCK_SIZE * (this.row / BLOCK_SIZE) + this.column / BLOCK_SIZE;
    }

    /**
     * Provides a coordinate in an easy to read format. Examples: C5, H9, B3 etc.
     *
     * @return the coordinate of this cell
     */
    public String getCoordinate() {
        return String.format("%s%s", COLUMNS.charAt(column), ROWS.charAt(row));
    }

}
