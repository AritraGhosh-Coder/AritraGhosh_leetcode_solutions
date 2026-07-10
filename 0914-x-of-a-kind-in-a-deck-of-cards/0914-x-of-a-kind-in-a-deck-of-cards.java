import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        // Step 1: Count frequencies of each card
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : deck) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }
        
        // Step 2: Find the GCD of all frequencies
        int res = 0;
        for (int count : countMap.values()) {
            res = gcd(count, res);
        }
        
        // The common group size X must be greater than or equal to 2
        return res >= 2;
    }
    
    // Helper method to find GCD using Euclidean algorithm
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}