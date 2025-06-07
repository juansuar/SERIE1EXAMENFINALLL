package org.example;

import java.util.HashSet;

/**
 * Implementación que valida un tablero de Sudoku según las reglas de filas, columnas y subcuadros 3x3.
 */
public class SudokuValidatorImpl implements SudokuValidator {

    @Override
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if (board[j][i] != '.' && !cols.add(board[j][i])) return false;
                int RowIndex = 3 * (i / 3), ColIndex = 3 * (i % 3);
                char c = board[RowIndex + j / 3][ColIndex + j % 3];
                if (c != '.' && !cube.add(c)) return false;
            }
        }
        return true;
    }
}