class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        // Since domino values are between 1 and 9, 
        // canonical key max value is 9 * 10 + 9 = 99.
        int[] counts = new int[100];
        int pairCount = 0;

        for (int[] domino : dominoes) {
            // Sort values to create a unique canonical key for both rotations
            int val1 = Math.min(domino[0], domino[1]);
            int val2 = Math.max(domino[0], domino[1]);
            int key = val1 * 10 + val2;

            // Each existing domino with the same key forms a new valid pair
            pairCount += counts[key];

            // Increment frequency for this key
            counts[key]++;
        }

        return pairCount;
    }
}