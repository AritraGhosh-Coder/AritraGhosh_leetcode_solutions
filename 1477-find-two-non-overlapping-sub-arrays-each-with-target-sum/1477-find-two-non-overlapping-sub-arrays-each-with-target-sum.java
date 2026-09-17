import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];
        Arrays.fill(minLen, Integer.MAX_VALUE);

        int left = 0;
        int currentSum = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            currentSum += arr[right];

            // Shrink window from the left if current sum exceeds target
            while (currentSum > target) {
                currentSum -= arr[left];
                left++;
            }

            // Check if a valid subarray ending at 'right' is found
            if (currentSum == target) {
                int currLen = right - left + 1;

                // If a non-overlapping valid subarray exists prior to 'left'
                if (left > 0 && minLen[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, minLen[left - 1] + currLen);
                }

                // Update minLen for current index
                minLen[right] = Math.min((right > 0 ? minLen[right - 1] : Integer.MAX_VALUE), currLen);
            } else {
                // Carry forward the best minimum length seen so far
                minLen[right] = (right > 0 ? minLen[right - 1] : Integer.MAX_VALUE);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}