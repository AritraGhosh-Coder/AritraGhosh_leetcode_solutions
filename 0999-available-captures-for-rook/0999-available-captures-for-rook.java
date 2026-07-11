class Solution {
    public int numRookCaptures(char[][] board) {
        int rookRow = -1;
        int rookCol = -1;
        
        // Step 1: Locate the white rook 'R'
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (board[r][c] == 'R') {
                    rookRow = r;
                    rookCol = c;
                    break;
                }
            }
            if (rookRow != -1) break;
        }
        
        int captures = 0;
        
        // Step 2: Define the 4 cardinal directions (Up, Down, Left, Right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Step 3: Scan outward in each direction
        for (int[] dir : directions) {
            int r = rookRow + dir[0];
            int c = rookCol + dir[1];
            
            while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                if (board[r][c] == 'B') {
                    // Friendly bishop blocks the path; stop scanning this line
                    break; 
                }
                if (board[r][c] == 'p') {
                    // Attackable pawn found; count it and stop scanning this line
                    captures++;
                    break; 
                }
                
                r += dir[0];
                c += dir[1];
            }
        }
        
        return captures;
    }
}