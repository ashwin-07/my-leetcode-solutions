class Solution {
    public void rotate(int[][] matrix) {
        
        int i = 0, j = matrix.length -1;
        
        while (i < j) {
            int[] temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
            i++;
            j--;
        }
        
        for (i = 0; i < matrix.length; i++) {
            for (j = i+1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp; 
            }
        }
    }
}