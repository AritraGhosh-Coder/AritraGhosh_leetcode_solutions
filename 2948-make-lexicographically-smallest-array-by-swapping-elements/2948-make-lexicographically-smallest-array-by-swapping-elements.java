import java.util.Arrays;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices based on corresponding values in nums
        Arrays.sort(indices, (a, b) -> Integer.compare(nums[a], nums[b]));

        int[] result = new int[n];

        int i = 0;
        while (i < n) {
            int j = i;
            // Identify connected component where adjacent differences <= limit
            while (j + 1 < n && nums[indices[j + 1]] - nums[indices[j]] <= limit) {
                j++;
            }

            // Extract and sort original index positions within the component
            int groupSize = j - i + 1;
            int[] groupIndices = new int[groupSize];
            for (int k = 0; k < groupSize; k++) {
                groupIndices[k] = indices[i + k];
            }
            Arrays.sort(groupIndices);

            // Assign values in sorted order to sorted index positions
            for (int k = 0; k < groupSize; k++) {
                result[groupIndices[k]] = nums[indices[i + k]];
            }

            i = j + 1;
        }

        return result;
    }
}