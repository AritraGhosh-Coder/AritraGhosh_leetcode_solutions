class Solution {
    public int findJudge(int n, int[][] trust) {
        // Track the net trust score for each person.
        // If person A trusts person B, person A loses 1 point and person B gains 1 point.
        int[] trustScores = new int[n + 1];
        
        for (int[] relation : trust) {
            int trsuter = relation[0];
            int trustee = relation[1];
            
            trustScores[trsuter]--;
            trustScores[trustee]++;
        }
        
        // The town judge will trust nobody (0 outbound) and be trusted by everybody else (n - 1 inbound).
        // Therefore, the judge's net score must be exactly n - 1.
        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }
        
        return -1;
    }
}