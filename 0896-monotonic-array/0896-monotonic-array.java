class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                isDecreasing = false; // Found an increase, so it can't be purely decreasing
            }
            if (nums[i] < nums[i - 1]) {
                isIncreasing = false; // Found a decrease, so it can't be purely increasing
            }
            
            // Optimization: If both flags become false, we can stop early
            if (!isIncreasing && !isDecreasing) {
                return false;
            }
        }
        
        return true;
    }
}