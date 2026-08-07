import java.util.Arrays;

class Solution {
    public String smallestNumber(String num, long t) {
        // Step 1: Prime factorize t (must only contain factors 2, 3, 5, 7)
        long tempT = t;
        int t2 = 0, t3 = 0, t5 = 0, t7 = 0;
        while (tempT % 2 == 0) { tempT /= 2; t2++; }
        while (tempT % 3 == 0) { tempT /= 3; t3++; }
        while (tempT % 5 == 0) { tempT /= 5; t5++; }
        while (tempT % 7 == 0) { tempT /= 7; t7++; }

        if (tempT > 1) {
            return "-1";
        }

        int n = num.length();

        // Track factor requirements after matching prefix of length i
        int[] req2 = new int[n + 1];
        int[] req3 = new int[n + 1];
        int[] req5 = new int[n + 1];
        int[] req7 = new int[n + 1];

        req2[0] = t2; req3[0] = t3; req5[0] = t5; req7[0] = t7;

        int firstZero = -1;

        for (int i = 0; i < n; i++) {
            int d = num.charAt(i) - '0';
            if (d == 0) {
                firstZero = i;
                break;
            }
            int[] f = getFactors(d);
            req2[i + 1] = Math.max(0, req2[i] - f[0]);
            req3[i + 1] = Math.max(0, req3[i] - f[1]);
            req5[i + 1] = Math.max(0, req5[i] - f[2]);
            req7[i + 1] = Math.max(0, req7[i] - f[3]);
        }

        // Case 1: Exact match of original number
        if (firstZero == -1 && req2[n] == 0 && req3[n] == 0 && req5[n] == 0 && req7[n] == 0) {
            return num;
        }

        // Case 2: Same length, increment at index i
        int limit = (firstZero == -1) ? n - 1 : firstZero;

        for (int i = limit; i >= 0; i--) {
            int startDigit = num.charAt(i) - '0' + 1;
            int remLen = n - 1 - i;

            for (int d = startDigit; d <= 9; d++) {
                int[] f = getFactors(d);
                int r2 = Math.max(0, req2[i] - f[0]);
                int r3 = Math.max(0, req3[i] - f[1]);
                int r5 = Math.max(0, req5[i] - f[2]);
                int r7 = Math.max(0, req7[i] - f[3]);

                String suffix = getSmallestSuffix(remLen, r2, r3, r5, r7);
                if (suffix != null) {
                    return num.substring(0, i) + d + suffix;
                }
            }
        }

        // Case 3: Greater length
        for (int len = n + 1; ; len++) {
            String suffix = getSmallestSuffix(len, t2, t3, t5, t7);
            if (suffix != null) {
                return suffix;
            }
        }
    }

    private int[] getFactors(int d) {
        int[] f = new int[4]; // 2, 3, 5, 7
        if (d == 2) f[0] = 1;
        else if (d == 3) f[1] = 1;
        else if (d == 4) f[0] = 2;
        else if (d == 5) f[2] = 1;
        else if (d == 6) { f[0] = 1; f[1] = 1; }
        else if (d == 7) f[3] = 1;
        else if (d == 8) f[0] = 3;
        else if (d == 9) f[1] = 2;
        return f;
    }

    // Correctly calculates the minimum number of digits needed to fulfill all factor requirements
    private int getMinLen(int r2, int r3, int r5, int r7) {
        int count8 = r2 / 3;
        int rem2 = r2 % 3;

        int count9 = r3 / 2;
        int rem3 = r3 % 2;

        int count = count8 + count9 + r5 + r7;

        if (rem2 == 0 && rem3 == 0) {
            // No leftover factors
        } else if (rem2 == 0 && rem3 == 1) {
            count += 1; // digit '3'
        } else if (rem2 == 1 && rem3 == 0) {
            count += 1; // digit '2'
        } else if (rem2 == 1 && rem3 == 1) {
            count += 1; // digit '6' (covers both 2 and 3!)
        } else if (rem2 == 2 && rem3 == 0) {
            count += 1; // digit '4'
        } else if (rem2 == 2 && rem3 == 1) {
            // 2 twos and 1 three can be '2' and '6' or '4' and '3' (takes 2 digits)
            count += 2;
        }

        return count;
    }

    // Constructs the lexicographically smallest suffix of length `availableLen`
    private String getSmallestSuffix(int availableLen, int r2, int r3, int r5, int r7) {
        if (getMinLen(r2, r3, r5, r7) > availableLen) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        // Greedily pick the smallest digit from 1 to 9 for each position
        for (int i = 0; i < availableLen; i++) {
            int remLen = availableLen - 1 - i;
            for (int d = 1; d <= 9; d++) {
                int[] f = getFactors(d);
                int nr2 = Math.max(0, r2 - f[0]);
                int nr3 = Math.max(0, r3 - f[1]);
                int nr5 = Math.max(0, r5 - f[2]);
                int nr7 = Math.max(0, r7 - f[3]);

                if (getMinLen(nr2, nr3, nr5, nr7) <= remLen) {
                    sb.append(d);
                    r2 = nr2;
                    r3 = nr3;
                    r5 = nr5;
                    r7 = nr7;
                    break;
                }
            }
        }

        return sb.toString();
    }
}