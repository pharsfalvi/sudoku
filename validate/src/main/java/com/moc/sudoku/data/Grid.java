package com.moc.sudoku.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents the Sudoku grid containing Cells.
 */
public class Grid {

    // a block contains 3x3 cells.
    public final static int BLOCK_SIZE = 3;
    // the grid contains 9x9 cells
    public final static int GRID_SIZE = 9;

    // Possible values of the column/row coordinates
    public final static String COLUMNS = "ABCDEFGHI";
    public final static String ROWS = "123456789";

    // Storage for the cells of this grid.
    private final List<Cell> cells = new ArrayList<>(GRID_SIZE * GRID_SIZE);

    public Grid() {
        // Initialize the grid with empty cells
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                cells.add(new Cell(row, column));
            }
        }
    }

    /**
     * Represents a row at a given index.
     *
     * @param index the index of the row.
     * @return the row.
     */
    public List<Cell> getRow(int index) {
        return cells.stream().filter(cell -> cell.getRow() == index).collect(Collectors.toList());
    }

    /**
     * Represents a column at a given index.
     *
     * @param index the index of the column.
     * @return the column
     */
    public List<Cell> getColumn(int index) {
        return cells.stream().filter(cell -> cell.getColumn() == index).collect(Collectors.toList());
    }

    /**
     * Retuns a Cell at a given [row,column] indices.
     *
     * @param row
     * @param column
     * @return the Cell located in the given position.
     */
    public Cell getCell(int row, int column) {
        Cell cell = cells.get(row * GRID_SIZE + column);
        return cell;
    }

    /**
     * Returns the list of cells of a given block. The blocks are numbered from left to right in the range of
     * 0..{@value #GRID_SIZE}-1 (inclusive).
     *
     * @param blockNumber the number of the block.
     * @return
     */
    public List<Cell> getBlock(int blockNumber) {
        return cells.stream().filter(cell -> cell.getBlockNumber() == blockNumber).collect(Collectors.toList());
    }

    /**
     * Returns the list of cells in this grid.
     *
     * @return the cells of this grid.
     */
    public List<Cell> getCells() {
        return cells;
    }
}
