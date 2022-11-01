class Solution {
    public int[] findBall(int[][] grid) {
        
        int[] result = new int[grid[0].length];
        
        for (int i = 0; i < grid[0].length; i++) {
            result[i] = findResultForColumn(0, i, grid);
        }
        
        return result;
        
    }
    
    int findResultForColumn(int row, int column, int[][] grid) {
        
        if (row == grid.length) {
            return column;
        }
        
        int nextColumn = column + grid[row][column];
        
        if (nextColumn < 0 || nextColumn >= grid[0].length || grid[row][column] != grid[row][nextColumn]) {
            return -1;
        }
        
        return findResultForColumn(row + 1, nextColumn, grid);
        
    }
    
    
}