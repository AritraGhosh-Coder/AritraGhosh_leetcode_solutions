import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String digits = "123456789";
        
        // Generate all possible sequential digit numbers using sliding windows
        for (int length = 2; length <= 9; length++) {
            for (int i = 0; i <= 9 - length; i++) {
                String sub = digits.substring(i, i + length);
                int num = Integer.parseInt(sub);
                
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        
        return result;
    }
}