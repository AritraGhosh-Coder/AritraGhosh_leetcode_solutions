class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int totalDistance = 0;
        int clockwiseDistance = 0;

        // Ensure start is smaller than destination for easy loop bounds
        int s = Math.min(start, destination);
        int d = Math.max(start, destination);

        for (int i = 0; i < distance.length; i++) {
            totalDistance += distance[i];
            
            // Add to clockwise distance if the segment falls between start and destination
            if (i >= s && i < d) {
                clockwiseDistance += distance[i];
            }
        }

        // Counterclockwise distance is total perimeter minus clockwise distance
        int counterClockwiseDistance = totalDistance - clockwiseDistance;

        return Math.min(clockwiseDistance, counterClockwiseDistance);
    }
}