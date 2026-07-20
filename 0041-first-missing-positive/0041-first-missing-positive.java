class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Place each number in its correct index position:
        // Value x should be placed at index x - 1
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        
        // Find the first index where the number doesn't match index + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        // If all numbers 1 to n are present, the answer is n + 1
        return n + 1;
    }
}