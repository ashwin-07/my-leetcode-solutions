class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int rows = maze.length, cols = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int steps = 0;
        
        queue.offer(entrance);
        visited[entrance[0]][entrance[1]] = true;
        
        while (!queue.isEmpty()) {
           int queueSize = queue.size();
            steps++;
            
            for (int i=0;i<queueSize;i++) {
                int[] curr = queue.poll();
                
                for (int[] dir: dirs) {
                    int x = dir[0]+curr[0];                    
                    int y = dir[1]+curr[1];
                    
                    if (x<0||x>=rows||y<0||y>=cols) continue;
                    if (visited[x][y] || maze[x][y] == '+') continue;
                    
                    if (x==0||x==rows-1||y==0||y==cols-1) return steps;
                    
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        
        return -1;
        
    }
}