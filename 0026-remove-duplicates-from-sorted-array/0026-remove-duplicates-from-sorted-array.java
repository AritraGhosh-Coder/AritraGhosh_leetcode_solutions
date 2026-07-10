class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        // 'i' keeps track of the position of the last found unique element
        int i = 0;
        
        // 'j' scans through the array starting from the second element
        for (int j = 1; j < nums.length; j++) {
            // If we find a new unique element
            if (nums[j] != nums[i]) {
                i++;             // Move the write pointer forward
                nums[i] = nums[j]; // Update the position with the unique element
            }
        }
        
        // The number of unique elements is the index 'i' + 1
        return i + 1;
    }
}