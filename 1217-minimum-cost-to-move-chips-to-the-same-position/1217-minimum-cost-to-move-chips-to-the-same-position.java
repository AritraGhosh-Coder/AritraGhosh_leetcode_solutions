class Solution {
    public int minCostToMoveChips(int[] position) {
        int evenCount = 0;
        int oddCount = 0;
        
        // Moving by 2 costs 0, so all even positions can group together at 0 cost,
        // and all odd positions can group together at 0 cost.
        for (int pos : position) {
            if (pos % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        
        // Move the smaller group to the larger group's position (cost 1 per chip)
        return Math.min(evenCount, oddCount);
    }
}