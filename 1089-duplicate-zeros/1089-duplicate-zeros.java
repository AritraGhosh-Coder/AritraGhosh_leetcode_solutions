class Solution {
    public void duplicateZeros(int[] arr) {
        int possibleZeros = 0;
        int length = arr.length - 1;

        // Step 1: Count how many zeros can fit within the array's bounds 
        // when each zero is duplicated.
        for (int i = 0; i <= length - possibleZeros; i++) {
            if (arr[i] == 0) {
                // Edge case: A zero is found at the boundary of our virtual array length.
                // We cannot duplicate it because the second copy would fall outside.
                if (i == length - possibleZeros) {
                    arr[length] = 0; // Copy the single zero to the very end
                    length--;        // Reduce the working length boundary
                    break;
                }
                possibleZeros++;
            }
        }

        // Step 2: Walk backwards from the end of the virtual array, 
        // copy elements to their new valid in-place positions.
        int lastIndex = length - possibleZeros;
        for (int i = lastIndex; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleZeros] = 0;
                possibleZeros--;
                arr[i + possibleZeros] = 0;
            } else {
                arr[i + possibleZeros] = arr[i];
            }
        }
    }
}