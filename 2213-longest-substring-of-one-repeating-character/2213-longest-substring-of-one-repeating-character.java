class Solution {
    static class Node {
        char leftChar, rightChar;
        int prefixLen, suffixLen, maxLen, len;
    }

    private Node[] tree;
    private char[] chars;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int k = queryIndices.length;
        chars = s.toCharArray();
        tree = new Node[4 * n];

        // Step 1: Build the segment tree
        build(1, 0, n - 1);

        int[] result = new int[k];

        // Step 2: Process each point update query
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char c = queryCharacters.charAt(i);
            chars[idx] = c;
            update(1, 0, n - 1, idx, c);
            result[i] = tree[1].maxLen; // Root stores global maximum
        }

        return result;
    }

    private void merge(Node parent, Node left, Node right) {
        parent.len = left.len + right.len;
        parent.leftChar = left.leftChar;
        parent.rightChar = right.rightChar;
        parent.prefixLen = left.prefixLen;
        parent.suffixLen = right.suffixLen;
        parent.maxLen = Math.max(left.maxLen, right.maxLen);

        // Check if adjacent characters at the split boundary are the same
        if (left.rightChar == right.leftChar) {
            parent.maxLen = Math.max(parent.maxLen, left.suffixLen + right.prefixLen);
            
            if (left.prefixLen == left.len) {
                parent.prefixLen = left.len + right.prefixLen;
            }
            if (right.suffixLen == right.len) {
                parent.suffixLen = right.len + left.suffixLen;
            }
        }
    }

    private void build(int node, int start, int end) {
        tree[node] = new Node();
        if (start == end) {
            tree[node].leftChar = chars[start];
            tree[node].rightChar = chars[start];
            tree[node].prefixLen = 1;
            tree[node].suffixLen = 1;
            tree[node].maxLen = 1;
            tree[node].len = 1;
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        merge(tree[node], tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, char c) {
        if (start == end) {
            tree[node].leftChar = c;
            tree[node].rightChar = c;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, c);
        } else {
            update(2 * node + 1, mid + 1, end, idx, c);
        }
        merge(tree[node], tree[2 * node], tree[2 * node + 1]);
    }
}