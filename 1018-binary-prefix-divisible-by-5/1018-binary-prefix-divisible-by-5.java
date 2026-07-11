import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>(nums.length);
        int currentRemainder = 0;
        
        for (int num : nums) {
            // Shift left by 1 (multiply by 2) and add the current bit.
            // Take modulo 5 at each step to prevent integer overflow.
            currentRemainder = (currentRemainder * 2 + num) % 5;
            
            result.add(currentRemainder == 0);
        }
        
        return result;
    }
}