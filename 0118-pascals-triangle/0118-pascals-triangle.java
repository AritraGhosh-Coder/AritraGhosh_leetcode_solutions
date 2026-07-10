import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            
            for (int j = 0; j <= i; j++) {
                // The first and last elements of any row are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Fetch the two elements directly above from the previous row
                    List<Integer> prevRow = triangle.get(i - 1);
                    int sum = prevRow.get(j - 1) + prevRow.get(j);
                    row.add(sum);
                }
            }
            
            triangle.add(row);
        }
        
        return triangle;
    }
}