class Solution {
    public int[] replaceElements(int[] arr) {
        int maxRight = -1;
        
        // Traverse from right to left, keeping track of the max seen so far
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            arr[i] = maxRight;
            maxRight = Math.max(maxRight, current);
        }
        
        return arr;
    }
}