class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        
        // Prefix sum array for fast range sum queries
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }

        // dp[i][j] stores the maximum score Alice can obtain from subsegment stoneValue[i...j]
        int[][] dp = new int[n][n];

        // Process subsegment lengths from 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                // Try partitioning subsegment [i, j] into [i, k] and [k+1, j]
                for (int k = i; k < j; k++) {
                    int leftSum = prefixSum[k + 1] - prefixSum[i];
                    int rightSum = prefixSum[j + 1] - prefixSum[k + 1];

                    if (leftSum < rightSum) {
                        // Bob throws away the right row (larger value)
                        dp[i][j] = Math.max(dp[i][j], leftSum + dp[i][k]);
                    } else if (leftSum > rightSum) {
                        // Bob throws away the left row (larger value)
                        dp[i][j] = Math.max(dp[i][j], rightSum + dp[k + 1][j]);
                    } else {
                        // Equal values: Alice can choose whichever row maximizes her final score
                        dp[i][j] = Math.max(dp[i][j], leftSum + Math.max(dp[i][k], dp[k + 1][j]));
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}