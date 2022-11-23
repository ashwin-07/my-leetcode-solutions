class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        
        for (int i = 0; i < 9; i++) {
            
            Set<Character> valuesInRow = new HashSet<>();
            Set<Character> valuesInColumn = new HashSet<>();
            Set<Character> valuesInBlock = new HashSet<>();
            
            for (int j = 0; j < 9; j++) {
                
                char rowVal = board[i][j];
                char colVal = board[j][i];
                
                int colStart = 3 * (i %3), colOffset = j % 3;
                int rowStart = 3 * (i / 3), rowOffset = j / 3;
            
                // System.out.println(3*(i/3));
                char blockVal = board[rowOffset + rowStart][colOffset + colStart];
                
                if (rowVal != '.' && !valuesInRow.add(rowVal)) 
                    return false;
                if (colVal != '.' && !valuesInColumn.add(colVal)) 
                    return false;
                if (blockVal != '.' && !valuesInBlock.add(blockVal)) 
                    return false;
            }
            
        }
        
        return true;
        
        
    }
}