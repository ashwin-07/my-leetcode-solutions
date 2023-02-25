class Solution {
    public int maxProfit(int[] prices) {
        
        int minSoFar = prices[0];
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit,prices[i] - minSoFar);
            if (prices[i] < minSoFar) {
                minSoFar = prices[i];
            }
        }
        
        return profit;
        
    }
}