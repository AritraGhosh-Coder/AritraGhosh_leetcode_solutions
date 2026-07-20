class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalSeconds = 0;
        
        for (int i = 0; i < points.length - 1; i++) {
            int deltaX = Math.abs(points[i + 1][0] - points[i][0]);
            int deltaY = Math.abs(points[i + 1][1] - points[i][1]);
            
            // Diagonal moves cover 1 unit horizontally and 1 unit vertically simultaneously.
            // The minimum time between two points is determined by the maximum of the horizontal and vertical distances (Chebyshev distance).
            totalSeconds += Math.max(deltaX, deltaY);
        }
        
        return totalSeconds;
    }
}