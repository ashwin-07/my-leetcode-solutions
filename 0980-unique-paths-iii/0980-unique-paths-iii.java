class Solution {
    
    int unvisitedCellCount = 1;
    int result = 0;
    
    public int uniquePathsIII(int[][] grid) {   
        
        int startI = 0, startJ = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                
                if (grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                }
                else if (grid[i][j] == 0) {
                    unvisitedCellCount++;
                }      
            }
        }
        
        findPathDfs(startI, startJ, grid);
        return result;   
    }
    
    public void findPathDfs(int i, int j, int[][] grid) {  
        
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1) {
            return;
        }
        else if (grid[i][j] == 2) {
           if (unvisitedCellCount == 0) {
               result++;
           }
            return;
        }
        
        --unvisitedCellCount;
        int cellVal = grid[i][j];
        grid[i][j] = -1;
        findPathDfs(i+1, j, grid);
        findPathDfs(i, j+1, grid);
        findPathDfs(i-1, j, grid);
        findPathDfs(i, j-1, grid);
        grid[i][j] = cellVal;
        ++unvisitedCellCount;
    }
}