class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        
        // dp[i][m] stores the maximum number of stones the current player can get 
        // starting at index i with the parameter M = m.
        int[][] dp = new int[n][n + 1];
        
        // suffixSum[i] stores the sum of all piles from index i to the end.
        int[] suffixSum = new int[n];
        
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        
        // Traverse backwards to fill the DP table
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                // If the player can take all the remaining piles
                if (i + 2 * m >= n) {
                    dp[i][m] = suffixSum[i];
                } else {
                    int maxStones = 0;
                    
                    // Try taking x piles, where 1 <= x <= 2 * m
                    for (int x = 1; x <= 2 * m; x++) {
                        int nextM = Math.min(n, Math.max(m, x));
                        
                        // Current player gets all remaining stones minus what the opponent will get optimally
                        maxStones = Math.max(maxStones, suffixSum[i] - dp[i + x][nextM]);
                    }
                    dp[i][m] = maxStones;
                }
            }
        }
        
        // Alice starts at index 0 with M = 1
        return dp[0][1];
    }
}