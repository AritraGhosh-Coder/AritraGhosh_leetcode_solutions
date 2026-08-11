class Solution {
    public int missingInteger(int[] nums) {
        // Step 1: Calculate the sum of the longest sequential prefix
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }
        
        // Step 2: Record all elements present in the array
        // Since the maximum value in nums is 50 according to constraints,
        // an array of size 51 is sufficient for O(1) lookups.
        boolean[] present = new boolean[51];
        for (int num : nums) {
            if (num <= 50) {
                present[num] = true;
            }
        }
        
        // Step 3: Find the smallest missing integer >= sum
        while (sum <= 50 && present[sum]) {
            sum++;
        }
        
        return sum;
    }
}
