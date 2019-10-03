package ru.job4j.array;

public class MatrixCheck {
    public static boolean isWith(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                char sign = board[i][j];
                if ((i == 0 || j == 0) && sign == 'X') {
                    boolean row = false;
                    boolean cell = false;
                    for (int k = 1; k < board.length; ++k) {
                        if (i == 0) {
                            if (board[k][j] != 'X') {
                                row = true;
                            }
                        }
                        if (j == 0) {
                             if (board[i][k] != 'X') {
                                 cell = true;
                             }
                        } else {
                            cell = true;
                        }

                        if (row && cell) return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}


