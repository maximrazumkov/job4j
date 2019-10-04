package ru.job4j.array;

public class MatrixCheck {

    public static boolean isWith(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            if (board[i][i] == 'X') {
                int countRow = 0;
                int countCall = 0;
                for (int j = 0; j < board.length; ++j) {
                    if (board[i][j] == 'X') {
                        ++countRow;
                    }
                    if (board[j][i] == 'X') {
                        ++countCall;
                    }
                }
                if (countRow == board.length || countCall == board.length) {
                    return true;
                }
            }
        }
        return false;
    }
}


