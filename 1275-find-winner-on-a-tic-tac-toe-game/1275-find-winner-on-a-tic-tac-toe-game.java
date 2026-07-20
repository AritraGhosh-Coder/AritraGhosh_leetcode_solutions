class Solution {
    public String tictactoe(int[][] moves) {
        // Track the count of marks for each player (0 for A, 1 for B)
        // 3 rows, 3 columns, 1 main diagonal, 1 anti-diagonal
        int[][] rows = new int[2][3];
        int[][] cols = new int[2][3];
        int[] diag1 = new int[2];
        int[] diag2 = new int[2];

        for (int i = 0; i < moves.length; i++) {
            int player = i % 2; // 0 for Player A, 1 for Player B
            int r = moves[i][0];
            int c = moves[i][1];

            // Increment count for current move
            rows[player][r]++;
            cols[player][c]++;
            if (r == c) diag1[player]++;
            if (r + c == 2) diag2[player]++;

            // Check if this move results in a win
            if (rows[player][r] == 3 || cols[player][c] == 3 || 
                diag1[player] == 3 || diag2[player] == 3) {
                return player == 0 ? "A" : "B";
            }
        }

        // If no player has won, check if the grid is full or still pending
        return moves.length == 9 ? "Draw" : "Pending";
    }
}