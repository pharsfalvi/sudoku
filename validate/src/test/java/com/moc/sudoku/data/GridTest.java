package com.moc.sudoku.data;

import com.moc.sudoku.service.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static com.moc.sudoku.data.Grid.GRID_SIZE;
import static org.junit.jupiter.api.Assertions.*;

class GridTest {


    public static final String BLOCK_MESSAGE = "Invalid Block cells calculated";


    private transient Grid grid;

    @BeforeEach
    void setup() {
        this.grid = new Grid();
    }

    @Test
    void givenAGrid_whenBlock0Retrieved_thenCellCoordinatesAreCorrect() {
        assertEquals("A1,B1,C1,A2,B2,C2,A3,B3,C3",
                cellsOfBlock(0), BLOCK_MESSAGE);
    }

    @Test
    void givenAGrid_whenBlock1Retrieved_thenCellCoordinatesAreCorrect() {
        assertEquals("D1,E1,F1,D2,E2,F2,D3,E3,F3",
                cellsOfBlock(1), BLOCK_MESSAGE);
    }

    @Test
    void givenAGrid_whenBlock2Retrieved_thenCellCoordinatesAreCorrect() {
        assertEquals("G1,H1,I1,G2,H2,I2,G3,H3,I3",
                cellsOfBlock(2), BLOCK_MESSAGE);
    }

    @Test
    void givenAGrid_whenBlock3Retrieved_thenCellCoordinatesAreCorrect() {
        assertEquals("A4,B4,C4,A5,B5,C5,A6,B6,C6",
                cellsOfBlock(3), BLOCK_MESSAGE);
    }

    @Test
    void givenAGrid_whenBlock4Retrieved_thenCellCoordinatesAreCorrect() {
        assertEquals("D4,E4,F4,D5,E5,F5,D6,E6,F6",
                cellsOfBlock(4), BLOCK_MESSAGE);
    }

    @Test
    void givenAGrid_whenBlock5Retrieved_thenCellCoordinatesAreCorrect() {
        assertEquals("G4,H4,I4,G5,H5,I5,G6,H6,I6",
                cellsOfBlock(5), BLOCK_MESSAGE);
    }

    @Test
    void givenAGrid_whenBlock6Retrieved_thenCellCoordinatesAreCorrect() {
        assertEquals("A7,B7,C7,A8,B8,C8,A9,B9,C9",
                cellsOfBlock(6), BLOCK_MESSAGE);
    }

    @Test
    void givenAGrid_whenBlock7Retrieved_thenCellCoordinatesAreCorrect() {
        assertEquals("D7,E7,F7,D8,E8,F8,D9,E9,F9",
                cellsOfBlock(7), BLOCK_MESSAGE);
    }

    @Test
    void givenAGrid_whenBlock8Retrieved_thenCellCoordinatesAreCorrect() {
        assertEquals("G7,H7,I7,G8,H8,I8,G9,H9,I9",
                cellsOfBlock(8), BLOCK_MESSAGE);
    }

    @Test
    void givenRowAndColumn_whenGetCell_thenCoordinatesMatch() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                Cell cell = this.grid.getCell(row, column);
                assertTrue(row == cell.getRow() && column == cell.getColumn(), "Invalid Coordinates");
            }
        }
    }

    @Test
    void givenGrid_whenCellsRetrieved_thenIsNotEmpty() {
        List<Cell> cells = this.grid.getCells();
        assertFalse(cells.isEmpty(), "No cells exist in the grid.");
    }

    @Test
    void givenGrid_whenTooBigValueIsSet_thenExceptionIsThrown() {
        assertThrows(ValidationException.class, () -> this.grid.getCell(5, 5).setValue(10), "Invalid value is set");
    }

    @Test
    void givenGrid_whenTooSmallValueIsSet_thenExceptionIsThrown() {
        assertThrows(ValidationException.class, () -> this.grid.getCell(5, 5).setValue(0), "Invalid value is set");
    }

    private String cellsOfBlock(int blockNumber) {
        return this.grid.getBlock(blockNumber).stream().map(Cell::getCoordinate).collect(Collectors.joining(","));
    }
}