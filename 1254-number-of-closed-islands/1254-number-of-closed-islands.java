class Solution {
    
    int[] XDIRS = {0, 1, 0, -1};
    int[] YDIRS = {-1, 0, 1, 0};
    
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int closedIslandCount = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    if (recurseAndFind(grid, i, j, rows, cols, visited)) {
                        closedIslandCount++;
                    }
                }
            }
        }
        return closedIslandCount;
    }

    public boolean recurseAndFind(int[][] grid, int currRow, int currCol, int rows, int cols,
                                  boolean[][] visited) {
        if (currRow < 0 || currRow >= grid.length || currCol < 0 || currCol >= grid[0].length) {
            return false;
        }
        if (grid[currRow][currCol] == 1 || visited[currRow][currCol]) {
            return true;
        }

        visited[currRow][currCol] = true;
        boolean isClosed = true;
        
        for (int i = 0; i < 4; i++) {
            int nextR = currRow + XDIRS[i];
            int nextC = currCol + YDIRS[i];
            if (!recurseAndFind(grid,nextR, nextC, rows, cols, visited)) {
                isClosed = false;
            }
        }

        return isClosed;
    }
}