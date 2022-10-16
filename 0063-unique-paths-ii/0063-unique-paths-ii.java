class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int columns = obstacleGrid[0].length;
        int rows = obstacleGrid.length;
        
        int paths[][] = new int[rows][columns];
        
        // if (obstacleGrid[0][0] == 0 )
        // paths[0][0] = 1;
        
        for (int i = 0; i < rows; i++) {
            
            if (obstacleGrid[i][0] == 1) {
                paths[i][0] = 0;
                break;
            }
            else {
                paths[i][0] = 1;
            }
            
        }
        
        for (int i = 0; i < columns; i++) {
            
            if (obstacleGrid[0][i] == 1) {
                paths[0][i] = 0;
                break;
            }
            else {
                paths[0][i] = 1;
            }
            
        }
        
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                
                if (obstacleGrid[i][j] == 1) {
                    paths[i][j] = 0;
                }
                else {
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];
                }
            }
        }
        
        return paths[rows-1][columns-1];
        
    }
}