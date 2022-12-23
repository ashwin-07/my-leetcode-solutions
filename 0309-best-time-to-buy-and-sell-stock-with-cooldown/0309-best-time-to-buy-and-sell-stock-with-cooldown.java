class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0, buy = Integer.MIN_VALUE, cooldown = 0;
        
        for (int i=0; i < prices.length; i++)
        {
            int prevSell = sell;
            sell = buy + prices[i];
            buy = Math.max(buy, cooldown-prices[i]);
            cooldown = Math.max(cooldown, prevSell);
        }
        return Math.max(sell, cooldown);   
    }
}