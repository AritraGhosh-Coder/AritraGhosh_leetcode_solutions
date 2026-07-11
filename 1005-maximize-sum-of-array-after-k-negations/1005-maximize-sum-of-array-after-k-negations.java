import java.util.Arrays;

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // Sort the array to easily target the smallest numbers (especially negatives)
        Arrays.sort(nums);
        
        // Flip as many negative numbers as possible while k > 0
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        
        // Calculate the current sum and find the absolute smallest element
        int sum = 0;
        int minVal = Integer.MAX_VALUE;
        
        for (int num : nums) {
            sum += num;
            minVal = Math.min(minVal, num);
        }
        
        // If k is still odd, flip the smallest value once to minimize the loss
        if (k % 2 != 0) {
            sum -= 2 * minVal;
        }
        
        return sum;
    }
}