import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Count frequencies of each number
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
        // Store frequencies in a set to check for uniqueness
        Set<Integer> uniqueCounts = new HashSet<>();
        for (int count : counts.values()) {
            if (!uniqueCounts.add(count)) {
                return false; // Duplicate frequency detected
            }
        }
        
        return true;
    }
}