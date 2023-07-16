package Backtracking;

import java.util.Arrays;

public class SudokuSolver {

    public static void main(String[] args) {
        char[][] sudokuBoard = {{'5','3','.','.','7','.','.','.','.'},
                                {'6','.','.','1','9','5','.','.','.'},
                                {'.','9','8','.','.','.','.','6','.'},
                                {'8','.','.','.','6','.','.','.','3'},
                                {'4','.','.','8','.','3','.','.','1'},
                                {'7','.','.','.','2','.','.','.','6'},
                                {'.','6','.','.','.','.','2','8','.'},
                                {'.','.','.','4','1','9','.','.','5'},
                                {'.','.','.','.','8','.','.','7','9'}};
        Solution solution = new Solution();
        solution.solveSudoku(sudokuBoard);
        for(char[] cells: sudokuBoard) {
            System.out.println(Arrays.toString(cells));
        }
    }

    static class Solution {
        public void solveSudoku(char[][] board) {
            recur(board);
        }

        public boolean recur(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        for (char k = '1'; k <= '9'; k++) {
                            if (isValidPosition(board, i, j, k)) {
                                board[i][j] = k;
                                if (recur(board)) {
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

        public boolean isValidPosition(char[][] board, int row, int col, char k) {
            for (int j = 0; j < 9; j++) {
                if (board[row][j] == k) {
                    return false;
                }
                if (board[j][col] == k) {
                    return false;
                }
                int subgridStartRow = 3 * (row / 3);
                int subgridStartCol = 3 * (col / 3);
                if (board[subgridStartRow + j / 3][subgridStartCol + j % 3] == k) {
                    return false;
                }
            }
            return true;
        }
    }
}
