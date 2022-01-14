package com.moc.sudoku.data;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static com.moc.sudoku.data.Grid.GRID_SIZE;
import static org.junit.jupiter.api.Assertions.*;

class GridTest {


    @Test
    public void givenAGrid_BlockCoordinatesAreCorrect(){
      assertEquals("A1,B1,C1,A2,B2,C2,A3,B3,C3", cellsOfBlock(0));
      assertEquals("D1,E1,F1,D2,E2,F2,D3,E3,F3", cellsOfBlock(1));
      assertEquals("G1,H1,I1,G2,H2,I2,G3,H3,I3", cellsOfBlock(2));
      assertEquals("A4,B4,C4,A5,B5,C5,A6,B6,C6", cellsOfBlock(3));
      assertEquals("D4,E4,F4,D5,E5,F5,D6,E6,F6", cellsOfBlock(4));
      assertEquals("G4,H4,I4,G5,H5,I5,G6,H6,I6", cellsOfBlock(5));
      assertEquals("A7,B7,C7,A8,B8,C8,A9,B9,C9", cellsOfBlock(6));
      assertEquals("D7,E7,F7,D8,E8,F8,D9,E9,F9", cellsOfBlock(7));
      assertEquals("G7,H7,I7,G8,H8,I8,G9,H9,I9", cellsOfBlock(8));
    }

    private String cellsOfBlock(int blockNumber) {
        return new Grid().getBlock(blockNumber).stream().map(Cell::getCoordinate).collect(Collectors.joining(","));
    }

    @Test
    public void givenRowAndColumn_whenGetCell_thenCoordinatesMatch(){
        Grid grid = new Grid();
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                Cell cell = grid.getCell(row, column);
                assertEquals(row, cell.getRow());
                assertEquals(column, cell.getColumn());
            }
        }
    }
}