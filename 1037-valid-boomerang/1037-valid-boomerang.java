class Solution {
    public boolean isBoomerang(int[][] points) {
        // Use the cross product / triangle area formula to check if the three points are collinear.
        // For points (x1, y1), (x2, y2), (x3, y3), they form a valid triangle (non-zero area) if:
        // x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2) != 0
        // This naturally handles duplicate points as well (area becomes 0).
        
        int x1 = points[0][0], y1 = points[0][1];
        int x2 = points[1][0], y2 = points[1][1];
        int x3 = points[2][0], y3 = points[2][1];
        
        return x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2) != 0;
    }
}