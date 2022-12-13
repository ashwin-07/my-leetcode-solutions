class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int i = 0;
        for (i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int minForCol = getMinFromPrev(j, matrix[i]);
                matrix[i+1][j] = minForCol + matrix[i+1][j];
            }
            
        }
        
        int min = matrix[i][0];
        for (int val:matrix[i]) {
            min = Math.min(val, min);
        }
        
        return min;
        
    }
    
    int getMinFromPrev(int currCol, int[] values) {
        
        int min = values[currCol];
        if (currCol - 1 >= 0) {
            min = Math.min(min, values[currCol - 1]);
        }
        if (currCol + 1 < values.length) {
            min = Math.min(min, values[currCol + 1]);
        }
        return min;
        
        
    }
}