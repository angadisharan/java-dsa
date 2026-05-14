package org.matools.java.sudoku;

public class SudokuProblem {

    public void solveSudoku(char[][] board) {

        solvBoard(board);
    }

    private Boolean solvBoard(char[][] board) {

        for(int i = 0; i < 9; i++) {

            for(int j = 0; j < 9 ;j++) {

                if(board[i][j] == '.') {

                    char validChar = '.';

                    for(char k = '1'; k <= '9' ; k++) {

                        if(isValid(i, j, k, board)) {

                            board[i][j] = k;

                            if(solvBoard(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private Boolean isValid(int i, int j, char c, char[][] board) {

        if(!isValidRow(i, j, c, board)) {
            return false;
        }

        if(!isValidColumn(i, j, c, board)) {
            return false;
        }

        if(!isValidGrid(i, j, c, board)) {
            return false;
        }

        return true;
    }

    private Boolean isValidRow(int x, int y, char c, char[][] board) {

        int i = y - 1;

        for(;i >= 0;i--) {

            if(board[x][i] == c) {
                return false;
            }
        }

        i = y + 1;

        for(;i < 9;i++) {

            if(board[x][i] == c) {
                return false;
            }
        }

        return true;
    }

    private Boolean isValidColumn(int x, int y, char c, char[][] board) {

        int i = x - 1;

        for(;i >= 0;i--) {

            if(board[i][y] == c) {
                return false;
            }
        }

        i = x + 1;

        for(;i < 9;i++) {

            if(board[i][y] == c) {
                return false;
            }
        }

        return true;
    }

    private Boolean isValidGrid(int x, int y, char c, char[][] board) {

        int xStart = (x / 3) * 3;
        int yStart = (y / 3) * 3;

        for(int i = xStart; i < xStart + 3; i++) {

            for(int j = yStart; j < yStart + 3 ;j++) {

                if(i == x && j == y) {
                    continue;
                }

                if(c == board[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printBoard(char[][] board) {

        for(int i = 0; i < 9; i++) {

            for(int j = 0; j < 9; j++) {

                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        SudokuProblem solution = new SudokuProblem();

        System.out.println("Before Solving:\n");
        printBoard(board);

        solution.solveSudoku(board);

        System.out.println("\nAfter Solving:\n");
        printBoard(board);
    }
}
