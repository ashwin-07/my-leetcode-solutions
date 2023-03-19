class WordDictionary {
    
    class TrieNode{
        Map<Character, TrieNode> children= new HashMap<>();
        boolean isWord = false;
    }

    TrieNode root;
    
    public WordDictionary() {
      root = new TrieNode();  
    }
    
    public void addWord(String word) {
        TrieNode currNode = root;
        for (char currCh: word.toCharArray()) {
            if (currNode.children.get(currCh) == null) {
               currNode.children.put(currCh, new TrieNode());
            }
            currNode = currNode.children.get(currCh);
        }
        currNode.isWord = true;
    }
    
    public boolean search(String word) {
        return findWord(word, 0, root);
    }
    
    private boolean findWord(String word, int currCharIdx, TrieNode currNode) {
        
       if (currNode == null) {
            return false;
        }

        if (currCharIdx == word.length()) {
            return currNode.isWord;
        }
        
        char currChar = word.charAt(currCharIdx);
        if (currChar == '.') {
            for (Character ch:currNode.children.keySet()) {
                if (findWord(word, currCharIdx + 1, currNode.children.get(ch))) {
                    return true;
                } 
            }  
        }
        else {
            return findWord(word, currCharIdx + 1, currNode.children.get(currChar));
        }
        return false;
        
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */