class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long[] added = new long[26];
        long total = 0;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            
            // New distinct subsequences ending at character 'c'
            long newAdded = (total + 1) % MOD;
            
            // Update total: subtract previous count for character 'c', then add newAdded
            total = (total - added[idx] + newAdded + MOD) % MOD;
            
            // Update record for character 'c'
            added[idx] = newAdded;
        }

        return (int) total;
    }
}