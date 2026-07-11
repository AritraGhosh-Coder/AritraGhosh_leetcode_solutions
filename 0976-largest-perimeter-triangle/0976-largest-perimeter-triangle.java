import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        // Sort the side lengths in ascending order
        Arrays.sort(nums);
        
        // Scan backwards to find the largest triplet that satisfies the triangle inequality theorem:
        // for any valid triangle with sides a <= b <= c, we must have a + b > c.
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        
        return 0;
    }
}