class Solution {
    public boolean exist(char[][] board, String word) {
        
        
        int x = board.length;
        int y = board[0].length;
        
        char[] wrd = word.toCharArray();
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                boolean result = find(i, j, wrd, board, 0);
                if (result) {
                    return true;
                }
                
            }
        }
        
        return false;
    
    }
    
    
    public boolean find(int i, int j, char[] word, char[][] board, int ind) {
        
        if (ind == word.length) {
            return true;
        }
        
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            return false;
        }
        
        if (board[i][j] != word[ind]){
            return false;
        }
        
        board[i][j]='#';
        
        boolean result = find(i+1, j , word, board, ind + 1) ||
            find(i, j+1 , word, board, ind + 1) ||
            find(i-1, j , word, board, ind + 1) ||
            find(i, j-1 , word, board, ind + 1);
        
        board[i][j]=word[ind];
        
        return result;
    }
    
}