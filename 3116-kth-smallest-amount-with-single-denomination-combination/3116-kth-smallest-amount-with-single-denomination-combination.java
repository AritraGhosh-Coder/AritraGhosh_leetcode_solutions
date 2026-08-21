import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        // Step 1: Filter out redundant coins (coins that are multiples of smaller coins)
        Arrays.sort(coins);
        List<Integer> filtered = new ArrayList<>();
        for (int c : coins) {
            boolean redundant = false;
            for (int existing : filtered) {
                if (c % existing == 0) {
                    redundant = true;
                    break;
                }
            }
            if (!redundant) {
                filtered.add(c);
            }
        }

        int n = filtered.size();

        // Step 2: Precompute LCM and sign (+1 for odd subset size, -1 for even) for PIE
        List<long[]> subsets = new ArrayList<>();
        int numSubsets = 1 << n;
        for (int mask = 1; mask < numSubsets; mask++) {
            long currentLcm = 1;
            int bitCount = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bitCount++;
                    currentLcm = lcm(currentLcm, filtered.get(i));
                }
            }
            int sign = (bitCount % 2 == 1) ? 1 : -1;
            subsets.add(new long[]{currentLcm, sign});
        }

        // Step 3: Binary Search on the answer
        long low = 1;
        long high = (long) filtered.get(0) * k;
        long result = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (countAmounts(mid, subsets) >= k) {
                result = mid;
                high = mid - 1; // Try to find a smaller valid amount
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    // Counts valid amounts <= x using the Principle of Inclusion-Exclusion
    private long countAmounts(long x, List<long[]> subsets) {
        long count = 0;
        for (long[] sub : subsets) {
            count += sub[1] * (x / sub[0]);
        }
        return count;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}