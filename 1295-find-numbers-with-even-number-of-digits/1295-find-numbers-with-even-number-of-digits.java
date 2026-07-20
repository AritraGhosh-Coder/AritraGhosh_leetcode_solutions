class Solution {
    public int findNumbers(int[] nums) {
        int evenDigitCount = 0;
        
        for (int num : nums) {
            // Formula to find the number of digits in an integer
            int digitCount = (int) Math.log10(num) + 1;
            
            if (digitCount % 2 == 0) {
                evenDigitCount++;
            }
        }
        
        return evenDigitCount;
    }
}