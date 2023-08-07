class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int l = 0, r = n*m - 1, mid =0;
        
        while (l < r) {
            
             mid = (r + l - 1) >>> 1;
            if (matrix[mid/m][mid%m] < target) {
                l = mid + 1; 
            }
            else {
                r = mid;
            }
            
        }
        
        return matrix[r / m][r % m] == target;
        
        
    }
}