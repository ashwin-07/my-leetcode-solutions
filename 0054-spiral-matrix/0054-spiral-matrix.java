class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<Integer>();
        int startRow = 0, endRow = matrix.length-1, startCol = 0, endCol =  matrix[0].length-1;

        while(startRow<=endRow && startCol <= endCol){
            for(int j=startCol; j<=endCol; j++){
                result.add(matrix[startRow][j]);
            }
            for(int i=startRow+1; i<=endRow; i++){
                result.add(matrix[i][endCol]);
            }
            for(int j= endCol-1; j>=startCol; j--){
                if(startRow==endRow){
                    break;
                }
                result.add(matrix[endRow][j]);
            }
            for(int i=endRow-1; i>=startRow+1; i--){
                if(startCol==endCol){
                    break;
                }
                result.add(matrix[i][startCol]);
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;     
        }
        return result;
    }
}