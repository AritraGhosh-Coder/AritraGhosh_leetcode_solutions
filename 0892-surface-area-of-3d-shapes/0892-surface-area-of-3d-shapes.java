class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int totalArea = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = grid[i][j];
                
                if (v > 0) {
                    // Add the base surface area for this tower (4 sides per cube + 1 top + 1 bottom)
                    totalArea += 4 * v + 2;
                    
                    // Subtract the overlapping faces glued to the right neighbor
                    if (j + 1 < n) {
                        totalArea -= 2 * Math.min(v, grid[i][j + 1]);
                    }
                    
                    // Subtract the overlapping faces glued to the bottom neighbor
                    if (i + 1 < n) {
                        totalArea -= 2 * Math.min(v, grid[i + 1][j]);
                    }
                }
            }
        }
        
        return totalArea;
    }
}