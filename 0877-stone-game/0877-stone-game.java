class Solution {
    public boolean stoneGame(int[] piles) {
        // Alice can always win under the given constraints:
        // 1. The total number of piles is even.
        // 2. The total sum of all stones is odd (no ties possible).
        // 
        // Strategy: Alice can partition the array into odd and even indices.
        // Sum(odd indices) != Sum(even indices) because the overall sum is odd.
        // Alice can force getting all odd-indexed piles or all even-indexed piles,
        // whichever set has a higher sum, guaranteeing a victory.
        return true;
    }
}