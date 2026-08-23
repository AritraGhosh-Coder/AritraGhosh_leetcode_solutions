class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sum1 = 0, sum2 = 0;
        int q1 = 0, q2 = 0;

        // Calculate known sums and count '?' in left and right halves
        for (int i = 0; i < n / 2; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                q1++;
            } else {
                sum1 += c - '0';
            }
        }

        for (int i = n / 2; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                q2++;
            } else {
                sum2 += c - '0';
            }
        }

        // For Bob to win, the net sum difference must be balanced out by the net '?' count.
        // Each pair of '?' on one side can be forced by Bob to add up to 9.
        // Therefore, Bob wins if and only if:
        // (sum1 - sum2) + (q1 - q2) / 2 * 9 == 0
        return (2 * (sum1 - sum2) + 9 * (q1 - q2)) != 0;
    }
}