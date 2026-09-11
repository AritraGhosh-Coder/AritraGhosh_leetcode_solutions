import java.util.HashSet;
import java.util.Set;

class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        int n = digits.length;

        // Try all permutations of 3 distinct indices (i, j, k)
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue; // No leading zero allowed

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                for (int k = 0; k < n; k++) {
                    if (i == k || j == k) continue;
                    if (digits[k] % 2 != 0) continue; // Must end in an even digit

                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    uniqueNumbers.add(num);
                }
            }
        }

        return uniqueNumbers.size();
    }
}