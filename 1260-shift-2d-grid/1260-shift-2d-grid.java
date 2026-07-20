import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int totalElements = m * n;
        
        // Effective shifts needed
        k = k % totalElements;
        
        // Initialize 2D list for the result
        List<List<Integer>> result = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            result.add(new ArrayList<>(n));
        }
        
        for (int i = 0; i < totalElements; i++) {
            // Find where this 1D flattened index should land after shifting
            int newIndex = (i + k) % totalElements;
            
            int newRow = newIndex / n;
            int newCol = newIndex % n;
            
            int origRow = i / n;
            int origCol = i % n;
            
            // Set up placeholder or directly add element based on destination index
            // Using direct row placement via flat mapping:
            while (result.get(newRow).size() <= newCol) {
                result.get(newRow).add(0);
            }
            result.get(newRow).set(newCol, grid[origRow][origCol]);
        }
        
        return result;
    }
}