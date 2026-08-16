class Solution {
    public boolean stoneGameIX(int[] stones) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        
        // Count frequencies of remainder when divided by 3
        for (int stone : stones) {
            int rem = stone % 3;
            if (rem == 0) cnt0++;
            else if (rem == 1) cnt1++;
            else cnt2++;
        }

        // Case 1: Even number of 0-remainder stones.
        // Type 0 stones cancel each other out in turn order.
        // Alice wins if she can pick a starter (1 or 2) and force Bob to run out of valid moves.
        if (cnt0 % 2 == 0) {
            return cnt1 >= 1 && cnt2 >= 1;
        }

        // Case 2: Odd number of 0-remainder stones.
        // The single effective 0-stone acts as a turn-reversal card.
        // Alice can win if the difference between count of 1s and 2s is greater than 2.
        return Math.abs(cnt1 - cnt2) > 2;
    }
}