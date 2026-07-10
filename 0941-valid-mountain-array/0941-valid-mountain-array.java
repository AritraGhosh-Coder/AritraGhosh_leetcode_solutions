class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        }
        
        int i = 0;
        
        // Walk up the mountain
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }
        
        // Peak cannot be the first or last element
        if (i == 0 || i == n - 1) {
            return false;
        }
        
        // Walk down the mountain
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }
        
        // Return true if we reached the end of the array
        return i == n - 1;
    }
}