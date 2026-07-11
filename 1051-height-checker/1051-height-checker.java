class Solution {
    public int heightChecker(int[] heights) {
        // Because heights are bounded between 1 and 100, we can use 
        // Counting Sort (Bucket Sort) to track the expected order in O(n) time.
        int[] heightCounts = new int[101];
        for (int height : heights) {
            heightCounts[height]++;
        }
        
        int mismatchCount = 0;
        int currentExpectedHeight = 0;
        
        for (int height : heights) {
            // Find the next available height that should be in the line
            while (heightCounts[currentExpectedHeight] == 0) {
                currentExpectedHeight++;
            }
            
            // If the actual student's height doesn't match the expected height, count it
            if (height != currentExpectedHeight) {
                mismatchCount++;
            }
            
            // Use up one student of this height
            heightCounts[currentExpectedHeight]--;
        }
        
        return mismatchCount;
    }
}