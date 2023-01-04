class Solution {
    public int combinationSum4(int[] coins, int amount) {
                        
        int[] dp = new int[amount+1];
        dp[0] = 1;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin: coins) {
                if (i < coin) {
                    continue;
                }
                dp[i]+=dp[i - coin];
            }
        }
        
        return dp[amount]; 
    }
}