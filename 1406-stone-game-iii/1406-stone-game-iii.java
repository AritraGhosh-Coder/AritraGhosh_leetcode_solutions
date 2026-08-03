class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        
        // dp[i] represents the maximum score advantage (Current Player Score - Opponent Score)
        // that the current player can achieve starting from index i to the end.
        int[] dp = new int[n + 1];

        // Traverse backwards from the end of the array
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MIN_VALUE;
            int takeSum = 0;

            // Try taking 1, 2, or 3 stones
            for (int k = 1; k <= 3 && i + k <= n; k++) {
                takeSum += stoneValue[i + k - 1];
                
                // Relative score advantage = points gained now - opponent's advantage from remainder
                dp[i] = Math.max(dp[i], takeSum - dp[i + k]);
            }
        }

        // Evaluate the maximum score advantage Alice can get starting at index 0
        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}