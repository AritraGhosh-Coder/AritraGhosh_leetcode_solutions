class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        
        // Compute prefix sums
        int[] prefixSum = new int[n];
        prefixSum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i];
        }
        
        // dp stores the optimal score difference for choices from index i to n - 1
        // Base case: index n - 1 (taking all remaining stones)
        int dp = prefixSum[n - 1];
        
        // Iterate backwards from index n - 2 down to 1
        for (int i = n - 2; i >= 1; i--) {
            dp = Math.max(dp, prefixSum[i] - dp);
        }
        
        return dp;
    }
}