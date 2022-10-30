class Solution {
    
    class PathDetails {
        
        int i; //curr row
        int j;  //curr col
        int remainingObstacleSkip;
        
        PathDetails(int i, int j, int remainingObstacleSkip) {
            this.i = i;
            this.j = j;
            this.remainingObstacleSkip = remainingObstacleSkip;
        }
        
    }
    
    public int shortestPath(int[][] grid, int k) {
        
        
        
        Queue<PathDetails> queue = new LinkedList<>();
        
        boolean[][][] visited = new boolean[grid.length][grid[0].length][k+1];
        
        int[][] directions = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}}; //right left up down
        
        int destinationRow = grid.length - 1;
        int destinationColumn = grid[0].length - 1;
        
        
        if (grid[0][0] == 0 || (grid[0][0] == 1 && k > 0)) { 
            queue.offer(new PathDetails(0,0,k-grid[0][0]));
        }
        
        int steps = 0;
        
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            
            
            while (size-- > 0) {
            
                PathDetails currPathDetails = queue.poll();

                int currRow = currPathDetails.i;
                int currCol = currPathDetails.j;
                
                int currObs = currPathDetails.remainingObstacleSkip;
                
                if (currRow == destinationRow && currCol == destinationColumn) {
                    return steps;
                }

                if (visited[currRow][currCol][currObs]) {
                    continue;
                }
                
                visited[currRow][currCol][currObs] = true;

                for (int[] dir: directions) {

                    int nextRow = currRow + dir[0];
                    int nextCol = currCol + dir[1]; 
                    
                    
                    if (nextRow >= 0 && nextCol >= 0 && nextCol < grid[0].length && nextRow < grid.length) {
                        
                        int remSkipObstaclesForNext = currPathDetails.remainingObstacleSkip - grid[nextRow][nextCol];
                        
                        
                        
                        if (remSkipObstaclesForNext < 0 || visited[nextRow][nextCol][remSkipObstaclesForNext]) {
                            continue;
                        }
                        
                        if (remSkipObstaclesForNext >= 0) {
                            queue.offer(new PathDetails(nextRow, nextCol, remSkipObstaclesForNext));
                        }
                        
                    }

                }
                
            }
            
            steps++;
            
        }
            
        
            
            
       return -1;     
        
        
        
    }
}