class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // Find the delta between the first two points
        int deltaX = coordinates[1][0] - coordinates[0][0];
        int deltaY = coordinates[1][1] - coordinates[0][1];
        
        // For points to be collinear, slope between point 0 and point i
        // must equal slope between point 0 and point 1.
        // Using cross product (dy1 * dx2 == dy2 * dx1) avoids division by zero.
        for (int i = 2; i < coordinates.length; i++) {
            int currentDeltaX = coordinates[i][0] - coordinates[0][0];
            int currentDeltaY = coordinates[i][1] - coordinates[0][1];
            
            if (deltaY * currentDeltaX != currentDeltaY * deltaX) {
                return false;
            }
        }
        
        return true;
    }
}