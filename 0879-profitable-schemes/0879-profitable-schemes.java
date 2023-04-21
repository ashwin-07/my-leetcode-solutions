class Solution {
    
    int MOD = 1000000007;
    
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp = new int[n + 1][minProfit + 1];
        dp[0][0] = 1;
        
        for (int k = 1; k <= group.length; k++) {
            int grp = group[k - 1];
            int minP = profit[k - 1];
            for (int i = n; i >= grp; i--) {
                for (int j = minProfit; j >= 0; j--) {
                    dp[i][j] = (dp[i][j] + dp[i - grp][Math.max(0, j - minP)])%MOD;
                }
            }
        }
        
        int sum = 0;                                                       
        for(int i = 0; i <= n; i++){
            sum = (sum + dp[i][minProfit]) % MOD;
        }
        return sum;
    }
}