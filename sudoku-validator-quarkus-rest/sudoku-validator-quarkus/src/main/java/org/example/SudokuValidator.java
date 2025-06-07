package org.example;

/**
 * Interfaz para validadores de Sudoku.
 */
public interface SudokuValidator {
    boolean isValidSudoku(char[][] board);
}