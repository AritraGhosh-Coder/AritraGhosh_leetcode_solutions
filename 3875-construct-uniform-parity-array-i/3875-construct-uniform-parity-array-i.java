class Solution {
    public boolean uniformArray(int[] nums1) {
        // It is always possible to form an array with uniform parity:
        // - All even nums1: keep as is for an all-even nums2.
        // - At least one odd in nums1: subtract that odd from all even elements (even - odd = odd) to make an all-odd nums2.
        return true;
    }
}