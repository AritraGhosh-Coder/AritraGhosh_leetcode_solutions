class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // dp[j] stores the number of subsequences matching t[0...j-1]
        int[] dp = new int[n + 1];
        
        // Base case: empty string t can be formed in 1 way by taking an empty subsequence
        dp[0] = 1;

        for (int i = 1; i <= m; i++) {
            char sChar = s.charAt(i - 1);
            // Iterate backwards through t to use space-optimized 1D array
            for (int j = n; j >= 1; j--) {
                if (sChar == t.charAt(j - 1)) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }

        return dp[n];
    }
}