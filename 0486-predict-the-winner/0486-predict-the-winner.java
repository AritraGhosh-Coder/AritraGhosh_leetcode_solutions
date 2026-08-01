class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        
        // dp[i][j] represents the maximum relative score advantage (Player's score - Opponent's score)
        // a player can achieve from the subarray nums[i...j].
        int[][] dp = new int[n][n];

        // Base case: Subarray of length 1, player just takes nums[i]
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        // Fill the DP table for subarray lengths from 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                // Pick nums[i] -> opponent gets optimal score advantage from dp[i+1][j]
                int pickLeft = nums[i] - dp[i + 1][j];
                
                // Pick nums[j] -> opponent gets optimal score advantage from dp[i][j-1]
                int pickRight = nums[j] - dp[i][j - 1];

                dp[i][j] = Math.max(pickLeft, pickRight);
            }
        }

        // If Player 1's score advantage over Player 2 across the full array is >= 0, Player 1 wins.
        return dp[0][n - 1] >= 0;
    }
}