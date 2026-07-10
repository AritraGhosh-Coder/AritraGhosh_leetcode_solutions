class Solution {
    public int maxProfit(int[] prices) {
        // Track the lowest price seen so far (initialize to a very high value)
        int minPrice = Integer.MAX_VALUE;
        // Track the maximum profit found
        int maxProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                // We found a new historical low price to buy at
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                // If selling today yields a better profit than before, update it
                maxProfit = prices[i] - minPrice;
            }
        }
        
        return maxProfit;
    }
}