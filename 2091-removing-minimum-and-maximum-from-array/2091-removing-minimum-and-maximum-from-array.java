class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int minIdx = 0;
        int maxIdx = 0;

        // Find indices of minimum and maximum elements
        for (int k = 1; k < n; k++) {
            if (nums[k] < nums[minIdx]) {
                minIdx = k;
            }
            if (nums[k] > nums[maxIdx]) {
                maxIdx = k;
            }
        }

        // Identify smaller (i) and larger (j) indices
        int i = Math.min(minIdx, maxIdx);
        int j = Math.max(minIdx, maxIdx);

        // Option 1: Remove both from the front (up to index j)
        int bothFront = j + 1;

        // Option 2: Remove both from the back (from index i to the end)
        int bothBack = n - i;

        // Option 3: Remove smaller index from front, larger index from back
        int split = (i + 1) + (n - j);

        return Math.min(bothFront, Math.min(bothBack, split));
    }
}