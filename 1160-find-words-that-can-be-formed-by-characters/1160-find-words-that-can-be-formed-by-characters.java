class Solution {
    public int countCharacters(String[] words, String chars) {
        // Frequency array for available characters
        int[] charCounts = new int[26];
        for (char c : chars.toCharArray()) {
            charCounts[c - 'a']++;
        }

        int totalLength = 0;

        // Check each word
        for (String word : words) {
            int[] wordCounts = new int[26];
            boolean canForm = true;

            for (char c : word.toCharArray()) {
                int index = c - 'a';
                wordCounts[index]++;

                // If word requires more of character c than available in chars
                if (wordCounts[index] > charCounts[index]) {
                    canForm = false;
                    break;
                }
            }

            if (canForm) {
                totalLength += word.length();
            }
        }

        return totalLength;
    }
}