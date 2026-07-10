import java.util.HashSet;
import java.util.Set;

class Solution {
    public int repeatedNTimes(int[] nums) {
        // Because n of the elements are unique and exactly one element is repeated n times,
        // any element that appears more than once must be the target answer.
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return num;
            }
        }
        return -1;
    }
}