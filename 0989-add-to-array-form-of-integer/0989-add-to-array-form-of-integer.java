import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int i = num.length - 1;
        
        // Loop through the array from right to left, or keep going as long as k has value left to add
        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];
                i--;
            }
            
            // Extract the current digit and append it
            result.add(k % 10);
            
            // Carry over the remaining value
            k /= 10;
        }
        
        // Since we built the result list backwards, reverse it to get the correct order
        Collections.reverse(result);
        
        return result;
    }
}