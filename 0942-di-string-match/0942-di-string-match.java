class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] perm = new int[n + 1];
        
        int low = 0;
        int high = n;
        
        // Greedy approach: 
        // If we see 'I', use the smallest available number to guarantee the next element is larger.
        // If we see 'D', use the largest available number to guarantee the next element is smaller.
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                perm[i] = low++;
            } else {
                perm[i] = high--;
            }
        }
        
        // Assign the final remaining number (at this point, low == high)
        perm[n] = low;
        
        return perm;
    }
}