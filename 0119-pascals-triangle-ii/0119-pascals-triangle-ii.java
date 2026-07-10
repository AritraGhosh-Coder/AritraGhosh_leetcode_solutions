import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        
        // Start by adding the very first element (1)
        row.add(1);
        
        for (int i = 1; i <= rowIndex; i++) {
            // Step 1: Add a placeholder '1' at the end of the current row
            row.add(1);
            
            // Step 2: Update the elements from right to left
            // This prevents overwriting the values from the previous iteration
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        
        return row;
    }
}