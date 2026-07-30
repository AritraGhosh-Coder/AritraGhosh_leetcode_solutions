class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int totalArea = 0;

        for (int i = 0; i < n; i++) {
            int maxRow = 0; // Max height in row i (Front/Back projection onto xz-plane)
            int maxCol = 0; // Max height in col i (Side projection onto yz-plane)

            for (int j = 0; j < n; j++) {
                // Top projection (xy-plane): count non-zero cells
                if (grid[i][j] > 0) {
                    totalArea++;
                }

                // Track row maximum
                maxRow = Math.max(maxRow, grid[i][j]);

                // Track column maximum
                maxCol = Math.max(maxCol, grid[j][i]);
            }

            // Add the shadows for this row and column
            totalArea += maxRow + maxCol;
        }

        return totalArea;
    }
}