class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int maxDistance = Math.max(rCenter, rows - 1 - rCenter) + Math.max(cCenter, cols - 1 - cCenter);
        
        // Count frequencies of each distance to set up bucket sizes
        int[] bucketCounts = new int[maxDistance + 1];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int dist = Math.abs(r - rCenter) + Math.abs(c - cCenter);
                bucketCounts[dist]++;
            }
        }
        
        // Calculate the starting index for each bucket in the final result array
        int[] bucketIndices = new int[maxDistance + 1];
        for (int i = 1; i <= maxDistance; i++) {
            bucketIndices[i] = bucketIndices[i - 1] + bucketCounts[i - 1];
        }
        
        // Place cells into their correct positions based on their distance
        int[][] result = new int[rows * cols][2];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int dist = Math.abs(r - rCenter) + Math.abs(c - cCenter);
                int destIndex = bucketIndices[dist];
                result[destIndex][0] = r;
                result[destIndex][1] = c;
                bucketIndices[dist]++;
            }
        }
        
        return result;
    }
}