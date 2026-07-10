class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        // XOR all the elements in the array
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }
}