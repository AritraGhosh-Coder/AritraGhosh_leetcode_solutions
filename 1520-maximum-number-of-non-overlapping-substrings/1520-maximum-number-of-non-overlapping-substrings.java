import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        // Record first and last occurrence of each character
        for (int i = 0; i < n; i++) {
            int charIdx = s.charAt(i) - 'a';
            if (first[charIdx] == -1) {
                first[charIdx] = i;
            }
            last[charIdx] = i;
        }

        List<int[]> validIntervals = new ArrayList<>();

        // Find valid substrings starting at first[c] for each character c
        for (int c = 0; c < 26; c++) {
            if (first[c] == -1) continue;

            int l = first[c];
            int r = last[c];
            boolean isValid = true;

            for (int j = l; j <= r; j++) {
                int charIdx = s.charAt(j) - 'a';
                // If a character inside [l, r] appeared before 'l', 
                // then 'l' cannot be the starting boundary of a valid substring.
                if (first[charIdx] < l) {
                    isValid = false;
                    break;
                }
                r = Math.max(r, last[charIdx]);
            }

            if (isValid) {
                validIntervals.add(new int[]{l, r});
            }
        }

        // Sort valid intervals by right endpoint in ascending order
        validIntervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        // Greedy interval selection (Activity Selection Problem)
        List<String> result = new ArrayList<>();
        int prevEnd = -1;

        for (int[] interval : validIntervals) {
            int start = interval[0];
            int end = interval[1];

            if (start > prevEnd) {
                result.add(s.substring(start, end + 1));
                prevEnd = end;
            }
        }

        return result;
    }
}