class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        
        
        
        int m = t1.length();
        int n = t2.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for (int i = 1; i <= m; i++) {
            for (int j =1; j <= n; j++) {
                if (t1.charAt(i-1) == t2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }  
            }
        }
        
        return dp[m][n];
        
    }
}