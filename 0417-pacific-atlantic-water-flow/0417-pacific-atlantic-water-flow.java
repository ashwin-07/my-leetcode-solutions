class Solution {
   
    
    int[][] directions = new int[][]{{0,1}, {1,0}, {-1, 0}, {0, -1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        
        List<List<Integer>> response = new ArrayList<>();
        
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        boolean[][] isAtlanticRechable = new boolean[rows][columns];
        boolean[][] isPacificRechable = new boolean[rows][columns];
        
        for (int i = 0; i < rows; i++) {
            findPath(matrix, isPacificRechable, i, 0);
            findPath(matrix, isAtlanticRechable, i, columns - 1);
        }
        
        for (int i = 0; i < columns; i++) {
            findPath(matrix, isPacificRechable, 0, i);
            findPath(matrix, isAtlanticRechable, rows - 1, i);
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (isAtlanticRechable[i][j] && isPacificRechable[i][j]) {
                    response.add(List.of(i,j));
                }
                
            }
            
        }
        
        return response;
        
    }
    
    public void findPath(int[][] matrix, boolean[][] reachable, int row, int column) {
        
        reachable[row][column] = true;
        
        for (int[] dir:directions) {
            
            int newRow = row + dir[0];
            int newCol = column + dir[1];
            
            if (newRow < 0 || newCol < 0 || newRow >= matrix.length 
                || newCol >= matrix[0].length 
               || reachable[newRow][newCol]
               || matrix[row][column] > matrix[newRow][newCol]) {
                continue;
            }
            
            findPath(matrix, reachable, newRow, newCol);
            
            
        }
        
    }
}