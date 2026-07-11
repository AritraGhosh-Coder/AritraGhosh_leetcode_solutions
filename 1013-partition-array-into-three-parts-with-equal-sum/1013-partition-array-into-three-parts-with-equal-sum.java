class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        // If the total sum cannot be divided evenly by 3, we can't partition it
        if (totalSum % 3 != 0) {
            return false;
        }
        
        int targetSum = totalSum / 3;
        int currentSum = 0;
        int partsFound = 0;
        
        // Traverse the array to count how many valid partitions we can make
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            
            // If the current partition matches the target sum
            if (currentSum == targetSum) {
                partsFound++;
                currentSum = 0; // Reset sum for the next part
            }
        }
        
        // We need at least 3 parts. If we find more than 3 parts (which can happen
        // when targetSum is 0), it's still valid since extra 0-sum blocks can merge.
        return partsFound >= 3;
    }
}