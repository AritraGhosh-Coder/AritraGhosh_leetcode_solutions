class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        
        // Count frequencies in s and subtract frequencies in target
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
            count[target.charAt(i) - 'a']--;
        }

        // Iterate backwards to find the longest target prefix target[0...i-1] we can match
        // while picking a character at index i strictly greater than target[i]
        for (int i = n - 1; i >= 0; i--) {
            // Restore target[i] to available counts for prefix target[0...i-1]
            count[target.charAt(i) - 'a']++;

            // Check if prefix target[0...i-1] can be validly formed (no negative character counts)
            boolean isValidPrefix = true;
            for (int c = 0; c < 26; c++) {
                if (count[c] < 0) {
                    isValidPrefix = false;
                    break;
                }
            }

            if (isValidPrefix) {
                // Look for the smallest available character c > target[i]
                int targetChar = target.charAt(i) - 'a';
                for (int c = targetChar + 1; c < 26; c++) {
                    if (count[c] > 0) {
                        // Found valid pivot index i and character c
                        StringBuilder sb = new StringBuilder();
                        
                        // 1. Prefix target[0...i-1]
                        sb.append(target, 0, i);
                        
                        // 2. Character c at index i
                        sb.append((char) ('a' + c));
                        count[c]--;

                        // 3. Fill remaining positions with remaining characters in ascending order
                        for (int ch = 0; ch < 26; ch++) {
                            while (count[ch] > 0) {
                                sb.append((char) ('a' + ch));
                                count[ch]--;
                            }
                        }

                        return sb.toString();
                    }
                }
            }
        }

        return "";
    }
}