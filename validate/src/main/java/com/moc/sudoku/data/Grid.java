package com.moc.sudoku.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Grid {

    public final static int BLOCK_SIZE = 3;
    public final static int GRID_SIZE = 9;

    public final static String ROWS = "123456789";
    public final static String COLUMNS = "ABCDEFGHI";

    private final List<Cell> cells = new ArrayList<>();

    public Grid() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                cells.add(new Cell(row, column));
            }
        }
    }

    public List<Cell> getRow(int index){
        return cells.stream().filter(cell -> cell.getRow() == index).collect(Collectors.toList());
    }

    public List<Cell> getColumn(int index){
        return cells.stream().filter(cell -> cell.getColumn() == index).collect(Collectors.toList());
    }

    public Cell getCell(int row, int column){
        Cell cell = cells.get(row * GRID_SIZE + column);
        assert cell.getRow() == row;
        assert cell.getColumn() == column;
        return cell;
    }

    public List<Cell> getBlock(int blockNumber){
        return cells.stream().filter(cell -> cell.getBlockNumber() == blockNumber).collect(Collectors.toList());
    }
}
