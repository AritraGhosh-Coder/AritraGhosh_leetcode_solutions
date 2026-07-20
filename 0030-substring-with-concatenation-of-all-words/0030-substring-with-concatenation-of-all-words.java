import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int totalWords = words.length;
        int totalLen = wordLen * totalWords;

        if (s.length() < totalLen) {
            return result;
        }

        // Frequency map for all words in the input array
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // Run sliding windows for each possible offset (0 to wordLen - 1)
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> currentCounts = new HashMap<>();
            int count = 0;

            while (right + wordLen <= s.length()) {
                String sub = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordCounts.containsKey(sub)) {
                    currentCounts.put(sub, currentCounts.getOrDefault(sub, 0) + 1);
                    count++;

                    // If a word appears more times than required, shrink window from left
                    while (currentCounts.get(sub) > wordCounts.get(sub)) {
                        String leftSub = s.substring(left, left + wordLen);
                        currentCounts.put(leftSub, currentCounts.get(leftSub) - 1);
                        left += wordLen;
                        count--;
                    }

                    // If valid window size reached, record starting index
                    if (count == totalWords) {
                        result.add(left);
                    }
                } else {
                    // Invalid word encountered; reset window state
                    currentCounts.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}