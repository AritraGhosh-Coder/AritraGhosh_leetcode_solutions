class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] charOrderMap = new int[26];
        
        // Map each character to its custom alphabetical index
        for (int i = 0; i < order.length(); i++) {
            charOrderMap[order.charAt(i) - 'a'] = i;
        }
        
        // Compare adjacent pairs of words
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSortedPair(words[i], words[i + 1], charOrderMap)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isSortedPair(String word1, String word2, int[] charOrderMap) {
        int len1 = word1.length();
        int len2 = word2.length();
        int minLen = Math.min(len1, len2);
        
        for (int j = 0; j < minLen; j++) {
            int char1Rank = charOrderMap[word1.charAt(j) - 'a'];
            int char2Rank = charOrderMap[word2.charAt(j) - 'a'];
            
            if (char1Rank != char2Rank) {
                // If they differ, the first word's character must be smaller
                return char1Rank < char2Rank;
            }
        }
        
        // If all characters match up to the length of the shorter word,
        // the shorter word must come first (e.g., "app" before "apple").
        return len1 <= len2;
    }
}