package com.moc.sudoku.service;

import com.moc.sudoku.data.Cell;
import com.moc.sudoku.data.Grid;

import java.util.*;
import java.util.stream.Collectors;

import static com.moc.sudoku.data.Grid.GRID_SIZE;
import static com.moc.sudoku.data.Grid.ROWS;
import static java.util.stream.Collectors.partitioningBy;

/**
 * This class validates a Sudoku grid to ensure that all rows,
 * all columns and all blocks contain the values as required.
 */
public class Validator {

    private final static List<Integer> EXPECTED_VALUES = new ArrayList<>(GRID_SIZE);

    /**
     * Validates the Sudoku grid.
     *
     * @param grid the grid to validate.
     * @throws ValidationException in case the validation fails.
     */
    public void validate(Grid grid) {
        // Each row, column and block contains GRID_SIZE elements.
        // Group them together and execute a check to ensure that all values are listed.
        for (int index = 0; index < GRID_SIZE; index++) {
            Map<String, List<Cell>> validationGroups = new HashMap<>();
            validationGroups.put("Row", grid.getRow(index));
            validationGroups.put("Column", grid.getColumn(index));
            validationGroups.put("Block", grid.getBlock(index));

            for (String validationGroup : validationGroups.keySet()) {
                List<Integer> groupCellValues = validationGroups.get(validationGroup).stream()
                        .map(Cell::getValue).collect(Collectors.toList());
                // Ensure that all cell has value
                if (groupCellValues.stream().anyMatch(val -> val == 0)) {
                    throw new ValidationException("%s %s is not valid, empty value found.", validationGroup,
                            ROWS.charAt(index));
                }
                // Determine the complement of the existing and desired values
                Map<Boolean, List<Integer>> partitionedValues = EXPECTED_VALUES.stream()
                        .collect(partitioningBy(groupCellValues::contains));
                // These values exist in the expected list but not in the actual validation group.
                List<Integer> missingValues = partitionedValues.get(false);
                if (!missingValues.isEmpty()) {
                    // fail the validation if any value is missing from the validation group.
                    throw new ValidationException("%s %s is not valid, missing values: %s", validationGroup,
                            ROWS.charAt(index), Arrays.toString(missingValues.toArray(Integer[]::new)));
                }
            }
        }
    }

    static {
        for (int val = 1; val <= GRID_SIZE; val++) {
            EXPECTED_VALUES.add(val);
        }
    }
}
