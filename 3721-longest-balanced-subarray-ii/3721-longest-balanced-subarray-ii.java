import java.util.Arrays;

class Solution {
    private int[] minVal;
    private int[] maxVal;
    private int[] lazy;

    public int longestBalanced(int[] nums) {
        int n = nums.length;
        minVal = new int[4 * n];
        maxVal = new int[4 * n];
        lazy = new int[4 * n];

        int maxNum = 0;
        for (int num : nums) {
            if (num > maxNum) {
                maxNum = num;
            }
        }

        int[] lastPos = new int[maxNum + 1];
        Arrays.fill(lastPos, -1);

        int maxLen = 0;

        for (int r = 0; r < n; r++) {
            int val = nums[r];
            int prev = lastPos[val];
            int delta = (val % 2 == 0) ? 1 : -1;

            // Update range of left endpoints L in (prev, r]
            update(1, 0, n - 1, prev + 1, r, delta);
            lastPos[val] = r;

            // Search for the smallest valid left endpoint L in [0, r] where balance D(L, r) == 0
            int l = findFirstZero(1, 0, n - 1, r);
            if (l != -1) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }

        return maxLen;
    }

    private void pushDown(int node) {
        if (lazy[node] != 0) {
            int val = lazy[node];

            lazy[2 * node] += val;
            minVal[2 * node] += val;
            maxVal[2 * node] += val;

            lazy[2 * node + 1] += val;
            minVal[2 * node + 1] += val;
            maxVal[2 * node + 1] += val;

            lazy[node] = 0;
        }
    }

    private void pushUp(int node) {
        minVal[node] = Math.min(minVal[2 * node], minVal[2 * node + 1]);
        maxVal[node] = Math.max(maxVal[2 * node], maxVal[2 * node + 1]);
    }

    private void update(int node, int start, int end, int l, int r, int val) {
        if (l > end || r < start) {
            return;
        }
        if (l <= start && end <= r) {
            lazy[node] += val;
            minVal[node] += val;
            maxVal[node] += val;
            return;
        }
        pushDown(node);
        int mid = start + (end - start) / 2;
        update(2 * node, start, mid, l, r, val);
        update(2 * node + 1, mid + 1, end, l, r, val);
        pushUp(node);
    }

    private int findFirstZero(int node, int start, int end, int maxR) {
        if (start > maxR || minVal[node] > 0 || maxVal[node] < 0) {
            return -1;
        }
        if (start == end) {
            return start;
        }
        pushDown(node);
        int mid = start + (end - start) / 2;
        int leftRes = findFirstZero(2 * node, start, mid, maxR);
        if (leftRes != -1) {
            return leftRes;
        }
        return findFirstZero(2 * node + 1, mid + 1, end, maxR);
    }
}