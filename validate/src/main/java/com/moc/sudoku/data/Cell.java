package com.moc.sudoku.data;


import static com.moc.sudoku.data.Grid.*;

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

    public void setValue(int value) {
        this.value = value;
    }

    public String getCoordinate() {
        return String.format("%s%s", COLUMNS.charAt(column), ROWS.charAt(row));
    }

    public int getBlockNumber(){
        return BLOCK_SIZE * (this.row / BLOCK_SIZE) + this.column / BLOCK_SIZE ;
    }

}
