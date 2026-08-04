import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> present = new HashSet<>();

        // Find min, max, and store all present elements in a set
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            present.add(num);
        }

        List<Integer> result = new ArrayList<>();

        // Collect all integers in [min, max] range that are missing
        for (int i = min + 1; i < max; i++) {
            if (!present.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}