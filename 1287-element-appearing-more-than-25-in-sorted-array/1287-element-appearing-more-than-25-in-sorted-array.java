class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int threshold = n / 4;
        
        // Since the array is sorted, any element occurring > 25% 
        // must match the element 'threshold' steps ahead of it.
        for (int i = 0; i < n - threshold; i++) {
            if (arr[i] == arr[i + threshold]) {
                return arr[i];
            }
        }
        
        return -1;
    }
}