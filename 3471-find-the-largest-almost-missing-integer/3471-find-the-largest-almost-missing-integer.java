import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> subarrayCount = new HashMap<>();

        // Iterate through all subarrays of size k
        for (int i = 0; i <= n - k; i++) {
            Set<Integer> distinctInSubarray = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                distinctInSubarray.add(nums[j]);
            }
            // Count occurrence of each distinct number per subarray
            for (int num : distinctInSubarray) {
                subarrayCount.put(num, subarrayCount.getOrDefault(num, 0) + 1);
            }
        }

        // Find the largest element that appeared in exactly 1 subarray
        int maxAlmostMissing = -1;
        for (Map.Entry<Integer, Integer> entry : subarrayCount.entrySet()) {
            if (entry.getValue() == 1) {
                maxAlmostMissing = Math.max(maxAlmostMissing, entry.getKey());
            }
        }

        return maxAlmostMissing;
    }
}