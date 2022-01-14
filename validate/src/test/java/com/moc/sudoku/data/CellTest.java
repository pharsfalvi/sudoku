package com.moc.sudoku.data;


import static com.moc.sudoku.data.Grid.BLOCK_SIZE;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CellTest {

    @Test
    public void givenCellCreated_thenBlockPositionIsCorrect() {
        int blockNumber = 0;
        for (int blockRow = 0; blockRow < BLOCK_SIZE; blockRow++) {
            for (int blockColumn = 0; blockColumn < BLOCK_SIZE; blockColumn++) {
                // For each block create all cells within it and check that the block number is correct.
                for (int cellRow = BLOCK_SIZE * blockRow; cellRow < BLOCK_SIZE * blockRow + BLOCK_SIZE; cellRow++) {
                    for (int cellColumn = BLOCK_SIZE * blockColumn; cellColumn < BLOCK_SIZE * blockColumn + BLOCK_SIZE; cellColumn++) {
                        assertEquals(blockNumber, new Cell(cellRow, cellColumn).getBlockNumber());
                    }
                }
                blockNumber++;
            }
        }
    }
}