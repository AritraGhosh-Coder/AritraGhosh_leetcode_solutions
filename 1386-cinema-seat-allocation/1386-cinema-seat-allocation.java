import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> occupied = new HashMap<>();

        // Group reserved seats by row (only seats 2 to 9 affect 4-person groups)
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (col >= 2 && col <= 9) {
                occupied.put(row, occupied.getOrDefault(row, 0) | (1 << col));
            }
        }

        // Bitmasks for the 3 possible 4-seat blocks
        int leftMask   = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);   // Seats 2, 3, 4, 5
        int middleMask = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);   // Seats 4, 5, 6, 7
        int rightMask  = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);   // Seats 6, 7, 8, 9

        // Completely unreserved rows (in seats 2-9) can fit 2 four-person groups each
        int totalGroups = (n - occupied.size()) * 2;

        // Process rows with at least one reservation in seats 2-9
        for (int mask : occupied.values()) {
            boolean leftFree = (mask & leftMask) == 0;
            boolean rightFree = (mask & rightMask) == 0;
            boolean middleFree = (mask & middleMask) == 0;

            if (leftFree && rightFree) {
                totalGroups += 2;
            } else if (leftFree || rightFree || middleFree) {
                totalGroups += 1;
            }
        }

        return totalGroups;
    }
}