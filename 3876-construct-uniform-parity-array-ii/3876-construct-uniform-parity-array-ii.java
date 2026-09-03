class Solution {
    public boolean uniformArray(int[] nums1) {
        int minVal = Integer.MAX_VALUE;
        boolean allEven = true;

        for (int num : nums1) {
            if (num % 2 != 0) {
                allEven = false;
            }
            if (num < minVal) {
                minVal = num;
            }
        }

        // We can form a uniform parity array if:
        // 1. All elements are already even (making nums2 all even).
        // 2. The minimum element is odd (enables subtracting the minimum odd
        //    from all even elements to make them odd, constructing an all-odd nums2).
        return allEven || (minVal % 2 != 0);
    }
}