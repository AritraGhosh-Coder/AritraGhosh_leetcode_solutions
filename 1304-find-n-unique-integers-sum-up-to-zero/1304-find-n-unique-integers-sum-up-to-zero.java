class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        
        // Fill pairs of (+i, -i)
        for (int i = 0; i < n / 2; i++) {
            result[i] = i + 1;
            result[n - 1 - i] = -(i + 1);
        }
        
        // If n is odd, the middle element defaults to 0 (default int value in array)
        return result;
    }
}