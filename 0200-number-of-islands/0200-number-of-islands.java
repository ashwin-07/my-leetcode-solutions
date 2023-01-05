class Solution {
    
    
    public int numIslands(char[][] grid) {
        
        int noOfIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    noOfIslands++;
                }
                submerge(grid,i,j);
            }
        }
        
        return noOfIslands;
        
    }
    
    
    void submerge(char[][] gridG,int i, int j) {
        
        if ((i < 0 || i >= gridG.length) || (j <0 || j >= gridG[0].length) || gridG[i][j] == '0') {
            return;
        }
        gridG[i][j] = '0';
        
        
        submerge(gridG ,i+1, j);
        submerge(gridG, i-1, j);
        submerge(gridG, i, j+1);
        submerge(gridG, i, j-1); 
    }
}