class Solution {
    public int maxDistance(int[][] grid) {
        
        int[][] dirs = new int[][]{{0,-1}, {-1, 0}, {1,0}, {0,1}};
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        int maxDistance = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] currCoords = queue.poll();
                
                for (int[] dir : dirs) {
                    int nextRow = currCoords[0] + dir[0];
                    int nextCol = currCoords[1] + dir[1];

                    if (nextRow >= 0 && nextCol >= 0 
                        && nextRow < grid.length && nextCol < grid[0].length 
                        && grid[nextRow][nextCol] == 0) {
                        grid[nextRow][nextCol] = 1;
                        queue.offer(new int[]{nextRow, nextCol});
                    }
                }
            }

            maxDistance++;
        }

        return maxDistance == 0 ? -1 : maxDistance;
        
    }
}