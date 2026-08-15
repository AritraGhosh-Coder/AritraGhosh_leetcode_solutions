class Solution {
    public int longestSubsequence(int[] nums) {
        int totalXOR = 0;
        boolean hasNonZero = false;

        for (int num : nums) {
            totalXOR ^= num;
            if (num != 0) {
                hasNonZero = true;
            }
        }

        // Case 1: If total XOR of the entire array is non-zero, the longest subsequence is the full array.
        if (totalXOR != 0) {
            return nums.length;
        }

        // Case 2: If total XOR is 0, removing any non-zero element x leaves a subsequence 
        // with XOR equal to (0 ^ x) = x != 0, giving length n - 1.
        if (hasNonZero) {
            return nums.length - 1;
        }

        // Case 3: All elements are 0, so no subsequence can have a non-zero XOR.
        return 0;
    }
}