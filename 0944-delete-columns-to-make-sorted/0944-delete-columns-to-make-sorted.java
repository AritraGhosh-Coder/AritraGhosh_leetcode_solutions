class Solution {
    public int minDeletionSize(String[] strs) {
        int deleteCount = 0;
        int numRows = strs.length;
        int numCols = strs[0].length();
        
        // Iterate through each column
        for (int c = 0; c < numCols; c++) {
            // Check rows from top to bottom for the current column
            for (int r = 1; r < numRows; r++) {
                if (strs[r].charAt(c) < strs[r - 1].charAt(c)) {
                    deleteCount++;
                    break; // Move to the next column as this one is already invalid
                }
            }
        }
        
        return deleteCount;
    }
}