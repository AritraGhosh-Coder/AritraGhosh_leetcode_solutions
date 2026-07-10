class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];
        
        // Find the absolute min and max in the array
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        // Calculate the minimized difference
        int res = (max - k) - (min + k);
        
        // If the max and min overlapped or crossed past each other, the minimum score is 0
        return Math.max(0, res);
    }
}