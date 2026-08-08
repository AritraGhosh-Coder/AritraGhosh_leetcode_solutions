import java.util.Arrays;

class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // last[j] stores the maximum index in word1 from which the suffix word2[j...m-1] 
        // can be matched EXACTLY.
        int[] last = new int[m + 1];
        Arrays.fill(last, -1);
        last[m] = n; // Base case: empty suffix can be matched after index n-1

        int p1 = n - 1;
        for (int p2 = m - 1; p2 >= 0; p2--) {
            // Find the rightmost index p1 < last[p2 + 1] where word1[p1] == word2[p2]
            p1 = Math.min(p1, last[p2 + 1] - 1);
            while (p1 >= 0 && word1.charAt(p1) != word2.charAt(p2)) {
                p1--;
            }
            if (p1 >= 0) {
                last[p2] = p1;
            } else {
                break; // If we can't match suffix from p2, earlier suffixes also won't match
            }
        }

        int[] result = new int[m];
        boolean usedModification = false;
        int i = 0; // Current index pointer in word1

        for (int j = 0; j < m; j++) {
            boolean matched = false;

            while (i < n) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    // 1. Exact Match: 
                    // Always take it as early as possible. We don't need to verify the rest 
                    // yet because saving the modification for later is always optimal.
                    result[j] = i;
                    i++;
                    matched = true;
                    break;
                } else if (!usedModification && last[j + 1] > i) {
                    // 2. Mismatch (Use Modification):
                    // Only allowed if we haven't used it AND we are guaranteed to 
                    // finish the remaining suffix EXACTLY.
                    usedModification = true;
                    result[j] = i;
                    i++;
                    matched = true;
                    break;
                }
                
                // If neither, skip this character in word1
                i++;
            }

            // If no valid index in word1 can match word2[j], return an empty array
            if (!matched) {
                return new int[0];
            }
        }

        return result;
    }
}