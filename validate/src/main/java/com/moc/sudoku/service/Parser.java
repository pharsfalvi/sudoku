package com.moc.sudoku.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static com.moc.sudoku.data.Grid.GRID_SIZE;

/**
 * Parses a csv into a list of String arrays
 */
public class Parser {

    /**
     * Loads a file.
     *
     * @param fileName the file to load.
     * @return the values from the csv in a List of String arrays.
     * @throws ValidationException in case the file cannot be read.
     */
    public List<String[]> load(String fileName) {
        if (fileName.isBlank()) {
            throw new ValidationException("Usage: validator%s <filename>",
                    System.getProperty("os.name").toLowerCase(Locale.ROOT).contains("win") ? ".bat" : "");
        }
        Path path = Paths.get(fileName);
        if (Files.notExists(path)) {
            throw new ValidationException("File %s does not exists.", fileName);
        } else if (Files.isDirectory(path)) {
            throw new ValidationException("%s is a directory.", fileName);
        } else {
            List<String[]> lines = loadFile(path);
            lines.forEach(line -> {
                if (line.length != GRID_SIZE) {
                    throw new ValidationException("Invalid row found. Each row must have exactly %d columns!", GRID_SIZE);
                }
            });
            return lines;
        }
    }

    private List<String[]> loadFile(Path path) {
        try {
            List<String[]> lines = Files.lines(path).map(line -> line.split(",")).collect(Collectors.toList());
            if (lines.size() != GRID_SIZE) {
                throw new ValidationException("The input file should have %d lines but it has %d", GRID_SIZE, lines.size());
            }
            return lines;
        } catch (Exception e) {
            throw new ValidationException(e.getMessage(), e);
        }
    }
}
