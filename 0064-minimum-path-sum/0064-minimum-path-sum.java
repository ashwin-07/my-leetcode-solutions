class Solution {
    public int minPathSum(int[][] grid) {
        
        int numOfCols = grid[0].length;
        int[] dp = new int[numOfCols];
        dp[0] = grid[0][0];
        
        for (int j = 1; j < grid[0].length; j++) {
           dp[j]+=dp[j-1]+grid[0][j]; 
        }
        
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0) {
                    dp[j]+=grid[i][j];
                }
                else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
                }
            }
        }
        
        return dp[grid[0].length - 1];  
    }
}