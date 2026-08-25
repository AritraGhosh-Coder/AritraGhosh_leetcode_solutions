import java.util.HashSet;
import java.util.Set;

class Solution {
    public int missingMultiple(int[] nums, int k) {
        // Store all elements in a set for O(1) lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Check positive multiples of k (k, 2k, 3k, ...)
        int multiple = k;
        while (set.contains(multiple)) {
            multiple += k;
        }

        return multiple;
    }
}