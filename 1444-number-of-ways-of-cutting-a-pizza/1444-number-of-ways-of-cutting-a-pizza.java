class Solution {

    Integer[][][] memo;
    final int MOD = 1000000007;

    public int ways(String[] pizza, int k) {
        
        int m = pizza.length, n = pizza[0].length();
        memo = new Integer[k][m][n];
        int[][] preSum = new int[m+1][n+1];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                preSum[i][j] = preSum[i][j + 1] + preSum[i + 1][j] - preSum[i + 1][j + 1] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
            }
        }
        
        return recurseAndCount(m, n, k-1, 0, 0, preSum);
    }

    int recurseAndCount(int m, int n, int k, int currRow, int currCol, int[][] preSum) {
        if (preSum[currRow][currCol] == 0) { 
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (memo[k][currRow][currCol] != null) {
            return memo[k][currRow][currCol];
        }
        
        int count = 0;
        
        for (int row = currRow + 1; row < m; row++) {
            if (preSum[currRow][currCol] - preSum[row][currCol] > 0) {
                count = (count + recurseAndCount(m, n, k - 1, row, currCol, preSum)) % MOD;
            }
        }
        
        for (int col = currCol + 1; col < n; col++) {
            if (preSum[currRow][currCol] - preSum[currRow][col] > 0) {
                count = (count + recurseAndCount(m, n, k - 1, currRow, col, preSum)) % MOD;
            }
        }
        return memo[k][currRow][currCol] = count;
    }
    
}
