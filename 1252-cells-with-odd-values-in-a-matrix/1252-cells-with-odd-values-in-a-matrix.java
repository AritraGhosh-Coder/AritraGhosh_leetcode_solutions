class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        boolean[] oddRows = new boolean[m];
        boolean[] oddCols = new boolean[n];
        
        // Track row and column increment counts using booleans (toggle parity)
        for (int[] index : indices) {
            oddRows[index[0]] = !oddRows[index[0]];
            oddCols[index[1]] = !oddCols[index[1]];
        }
        
        int oddRowCount = 0;
        for (boolean r : oddRows) {
            if (r) oddRowCount++;
        }
        
        int oddColCount = 0;
        for (boolean c : oddCols) {
            if (c) oddColCount++;
        }
        
        // Total odd cells = (odd rows * even cols) + (even rows * odd cols)
        return oddRowCount * (n - oddColCount) + (m - oddRowCount) * oddColCount;
    }
}