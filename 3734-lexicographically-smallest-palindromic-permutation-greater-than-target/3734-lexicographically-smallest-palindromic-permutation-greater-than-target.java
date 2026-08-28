class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        // Check if s can form a palindrome (at most 1 odd frequency character)
        int oddCount = 0;
        char mid = 0;
        for (int c = 0; c < 26; c++) {
            if (count[c] % 2 != 0) {
                oddCount++;
                mid = (char) ('a' + c);
            }
        }
        if (oddCount > 1) {
            return "";
        }

        int k = n / 2;
        int[] halfCount = new int[26];
        for (int c = 0; c < 26; c++) {
            halfCount[c] = count[c] / 2;
        }

        // Candidate 1: First half equals target[0...k-1]
        int[] targetHalfCount = new int[26];
        for (int j = 0; j < k; j++) {
            targetHalfCount[target.charAt(j) - 'a']++;
        }

        boolean match = true;
        for (int c = 0; c < 26; c++) {
            if (targetHalfCount[c] != halfCount[c]) {
                match = false;
                break;
            }
        }

        if (match) {
            String p1 = buildPalindrome(target.substring(0, k), mid, n);
            if (p1.compareTo(target) > 0) {
                return p1;
            }
        }

        // Candidate 2: First half strictly greater than target[0...k-1]
        int[] avail = new int[26];
        System.arraycopy(halfCount, 0, avail, 0, 26);
        for (int j = 0; j < k; j++) {
            avail[target.charAt(j) - 'a']--;
        }

        for (int i = k - 1; i >= 0; i--) {
            int targetCharIndex = target.charAt(i) - 'a';
            avail[targetCharIndex]++;

            // Check if prefix target[0...i-1] is valid
            boolean validPrefix = true;
            for (int c = 0; c < 26; c++) {
                if (avail[c] < 0) {
                    validPrefix = false;
                    break;
                }
            }

            if (validPrefix) {
                // Find smallest character > target[i] available
                int chosen = -1;
                for (int c = targetCharIndex + 1; c < 26; c++) {
                    if (avail[c] > 0) {
                        chosen = c;
                        break;
                    }
                }

                if (chosen != -1) {
                    // Construct the first half H
                    char[] H = new char[k];
                    for (int j = 0; j < i; j++) {
                        H[j] = target.charAt(j);
                    }
                    H[i] = (char) ('a' + chosen);
                    avail[chosen]--;

                    // Fill remaining positions in ascending order
                    int pos = i + 1;
                    for (int c = 0; c < 26; c++) {
                        while (avail[c] > 0) {
                            H[pos++] = (char) ('a' + c);
                            avail[c]--;
                        }
                    }

                    return buildPalindrome(new String(H), mid, n);
                }
            }
        }

        return "";
    }

    private String buildPalindrome(String firstHalf, char mid, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(firstHalf);
        if (n % 2 == 1) {
            sb.append(mid);
        }
        for (int j = firstHalf.length() - 1; j >= 0; j--) {
            sb.append(firstHalf.charAt(j));
        }
        return sb.toString();
    }
}