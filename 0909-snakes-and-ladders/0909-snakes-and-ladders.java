class Solution {
    
    public int getBoardVal(int[][] board, int val) {
        int n = board.length;
        int row = (val - 1) / n;
        
        int rowInBoard = n - 1 - row;
        
        int col = (val - 1) % n;
        int colInBoard = row % 2 == 0? col : n - 1 - col;
        
        return board[rowInBoard][colInBoard];
        
    }
    
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length;
        boolean[] visited = new boolean[n*n+1];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        
        int level = 0;
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            while(size-- > 0) {
                
                int curr = queue.poll();
                if (visited[curr]) {
                    continue;
                }
                visited[curr] = true;
                if (curr == n*n) {
                    return level;
                }
                
                for (int i = 1; i <= 6 && i+curr <= n*n; i++) {
                    int next = curr+i;
                    int nextVal = getBoardVal(board, next);
                    if (nextVal > 0) {
                        next = nextVal;
                    }
                    if (!visited[next]) {
                        queue.offer(next);
                    }
                }
                
            }
            level++;
        }
        
        return -1;
        
    }
}