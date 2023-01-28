class Solution {
    
    static int[][] dirs = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        
        int max = 1;
        
        int[][] memo = new int[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            
            for (int j = 0; j < matrix[0].length; j++) {
                
                int len = dfs(memo, i, j, matrix);
                max = Math.max(max, len);
            }
            
        }
        
        return max;
        
    }
    
    
    public int dfs(int[][] memo, int i, int j, int[][] matrix) {
        
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        
        int max = 1;
        for (int ii = 0; ii < 4; ii++) {
                
            int nextI = i + dirs[ii][0];
            int nextJ = j + dirs[ii][1];
                
                if (nextI < 0 || nextJ < 0 || nextI >= matrix.length || nextJ >= matrix[0].length || matrix[i][j] >= matrix[nextI][nextJ]) {
                 continue;   
                }
            
            int len = dfs(memo, nextI, nextJ, matrix) + 1;
            
            max = Math.max(max, len);
                
            
            
        }
        
        memo[i][j] = max;
        
        return max;
        
        
    }
}