class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int rows = mat.length, cols = mat[0].length;
        int maxPossibleDist =rows+cols;
        
        for (int currRow = 0; currRow < rows; currRow++) {
            for (int currCol = 0; currCol < cols; currCol++) {
                
                if (mat[currRow][currCol] != 0) {
                    int leftDist = maxPossibleDist, topDist = maxPossibleDist;    
                    if (currCol >= 1) {
                        leftDist = mat[currRow][currCol-1];
                    }
                    if (currRow >= 1) {
                        topDist = mat[currRow-1][currCol];
                    }
                    mat[currRow][currCol] = Math.min(topDist, leftDist) + 1;
                    
                }
            }
        }
        
        for (int currRow = rows - 1; currRow >= 0; currRow--) { 
            for (int currCol = cols - 1; currCol >= 0; currCol--) {
               if (mat[currRow][currCol] != 1) {
                    int rightDist = maxPossibleDist, bottomDist = maxPossibleDist;    
                    if (currCol+1 < cols) {
                        rightDist = mat[currRow][currCol+1];
                    }
                    if (currRow+1 < rows) {
                        bottomDist = mat[currRow+1][currCol];
                    }
                    int minDist = Math.min(rightDist, bottomDist) + 1;
                    mat[currRow][currCol] = Math.min(mat[currRow][currCol], minDist);
               }
            }            
        }
        
        return mat;
        
    }
}