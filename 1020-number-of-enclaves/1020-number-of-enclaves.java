class Solution {
    public int numEnclaves(int[][] grid) {
        int result = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j <grid[i].length; j++) {
                if(i == 0 || j == 0 
                   || i == grid.length - 1 || j == grid[i].length - 1) {
                    submergeLand(grid, i, j);
                }
            }
        }
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    result++;
                }
            }
        }
        
        return result;
    }
    
    
    public void submergeLand(int grid[][], int i, int j) {
        if(i >= 0 && i <= grid.length - 1 && 
           j >= 0 && j <= grid[i].length - 1 && grid[i][j] == 1) {
            
            grid[i][j] = 0; //submerge the land
            
            submergeLand(grid, i - 1, j); //top
            submergeLand(grid, i + 1, j); //bottom
            submergeLand(grid, i, j - 1); //left
            submergeLand(grid, i, j + 1); //right
        }
    }
}