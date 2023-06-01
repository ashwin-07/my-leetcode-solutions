class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int r = grid.length;
        int c = grid[0].length;
        
        int[][] dirs = new int[][]{
            
            {0,1},
            {1,0},
            {0, -1},
            {-1, 0},
            {-1,-1},
            {1,1},
            {1,-1},
            {-1, 1}
            
        };
        
        
        if ( grid[0][0] == 1 || grid[r-1][c-1] == 1) {
            return -1;
        }
        
        boolean[][] visited = new boolean[r][c];
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{0,0});
        
        int dist = 0;
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            int itrc = 0;
            while (itrc < size) {
                itrc++;
            int i = queue.peek()[0];
            int j = queue.poll()[1];
                     
            if (i == r-1 && j == c-1) {
                return dist+1;
            }
            
            for (int k = 0; k < dirs.length; k++) {
                
                int newI = i + dirs[k][0];
                int newJ = j + dirs[k][1];
                
                if (newI >= 0 && newI < r && newJ >= 0 && newJ < c && !visited[newI][newJ] && grid[newI][newJ] == 0) {
                    queue.add(new int[]{newI, newJ});
                    visited[newI][newJ] = true;
                }
          
              }
                
            }
            
            
            dist++;
        }
       return -1; 
    }
}