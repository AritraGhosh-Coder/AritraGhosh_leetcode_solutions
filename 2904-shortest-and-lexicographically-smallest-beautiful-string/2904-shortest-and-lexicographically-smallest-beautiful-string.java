import java.util.ArrayList;
import java.util.List;

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<Integer> ones = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones.add(i);
            }
        }

        // If total count of '1's is less than k, no beautiful substring exists
        if (ones.size() < k) {
            return "";
        }

        String result = "";
        int minLen = Integer.MAX_VALUE;

        // Any minimal beautiful substring with k ones must start at ones[i] and end at ones[i + k - 1]
        for (int i = 0; i <= ones.size() - k; i++) {
            int start = ones.get(i);
            int end = ones.get(i + k - 1);
            int len = end - start + 1;
            String sub = s.substring(start, end + 1);

            if (len < minLen) {
                minLen = len;
                result = sub;
            } else if (len == minLen && sub.compareTo(result) < 0) {
                result = sub;
            }
        }

        return result;
    }
}