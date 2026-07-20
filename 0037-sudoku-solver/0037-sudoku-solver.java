class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            // Recursively attempt to fill the rest of the board
                            if (solve(board)) {
                                return true;
                            }

                            // Backtrack if placing 'num' doesn't lead to a solution
                            board[row][col] = '.';
                        }
                    }
                    return false; // No valid number fits here
                }
            }
        }
        return true; // Entire board is filled successfully
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            // Check row constraint
            if (board[row][i] == ch) return false;
            
            // Check column constraint
            if (board[i][col] == ch) return false;
            
            // Check 3x3 sub-box constraint
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == ch) return false;
        }
        return true;
    }
}
