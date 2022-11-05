class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        Set<String> result = new HashSet<>();
        TrieNode root = TrieUtils.constructTrie(words);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfsAndFindWords(i, j, board, root, result);
            }
        }
        
        return new ArrayList<>(result);
        
    }
    
    void dfsAndFindWords(int i, int j, char[][] board, TrieNode trieNode, Set<String> result) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        
        char curChar = board[i][j];
        
        //already visited or not a word in dict
        if (curChar == '#' || trieNode.next[curChar - 'a'] == null) {
            return;
        }
        
        //get the node for the curr char in board
        trieNode = trieNode.next[curChar - 'a'];
        
        if (trieNode.word != null) {
            result.add(trieNode.word);
            trieNode.word = null;
        }
        
        board[i][j] = '#'; //marking it as visited

        dfsAndFindWords(i+1, j, board, trieNode, result);
        dfsAndFindWords(i, j+1, board, trieNode, result);
        dfsAndFindWords(i-1, j, board, trieNode, result);
        dfsAndFindWords(i, j-1, board, trieNode, result);

        board[i][j] = curChar; 
    }
}


class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word =  null;


}

class TrieUtils {

    public static TrieNode constructTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieNode currNode = root;
            for (char ch:word.toCharArray()) {
                int nextIdx = ch - 'a';
                if (currNode.next[nextIdx] == null) {
                    currNode.next[nextIdx] = new TrieNode();
                }
                currNode = currNode.next[nextIdx];
            }
            currNode.word = word;

        }
        return root;
    }

}