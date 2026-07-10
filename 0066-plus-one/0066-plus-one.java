class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Traverse the array from right to left (least significant to most significant)
        for (int i = n - 1; i >= 0; i--) {
            // If the current digit is less than 9, just increment it and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            // If the digit is 9, it becomes 0 due to the carry
            digits[i] = 0;
        }
        
        // If the loop finished, it means all digits were 9 (e.g., [9, 9, 9])
        // We need a new array of size n + 1, with the first digit as 1
        int[] result = new int[n + 1];
        result[0] = 1; // Remaining indices default to 0 in Java
        
        return result;
    }
}