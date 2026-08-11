class Solution {
    public boolean winnerSquareGame(int n) {
        // dp[i] represents whether the player whose turn it is can win with i stones left
        boolean[] dp = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            // Try removing every possible square number (1, 4, 9, 16, ...)
            for (int k = 1; k * k <= i; k++) {
                // If removing k*k stones leaves the opponent in a losing state (!dp[i - k*k]),
                // then the current player can force a win.
                if (!dp[i - k * k]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}