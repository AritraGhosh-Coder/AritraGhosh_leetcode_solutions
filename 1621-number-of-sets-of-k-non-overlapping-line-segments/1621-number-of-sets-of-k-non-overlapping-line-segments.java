class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
        int N = n + k - 1;
        int K = 2 * k;

        // Compute C(N, K) % MOD using 1D Pascal's Triangle DP
        long[] dp = new long[K + 1];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = Math.min(i, K); j > 0; j--) {
                dp[j] = (dp[j] + dp[j - 1]) % MOD;
            }
        }

        return (int) dp[K];
    }
}