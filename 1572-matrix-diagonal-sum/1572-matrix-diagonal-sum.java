class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = n % 2 == 0 ? 0 : -mat[n/2][n/2];
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[n-1-i][i];
        }
        return  sum;
    }
}