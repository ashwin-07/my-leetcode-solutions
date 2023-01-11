class Trie {

    class TrieNode {
        char value;
        String word;
        TrieNode[] children;
        
        TrieNode(char value, String word) {
            this.value = value;
            this.word = word;
            this.children = new TrieNode[26];
        }
    }

    TrieNode root;
    
    public Trie() {
       root = new TrieNode('*', null); 
    }
    
    public void buildTrie(String word) {
        
        TrieNode parent = root;
        int i = 0;
        while (i < word.length() && parent.children[word.charAt(i) - 'a'] != null) {
            parent = parent.children[word.charAt(i) - 'a'];
            i++;
        }
        
        while(i < word.length()) {
            TrieNode newNode = new TrieNode(word.charAt(i), null);
            parent.children[word.charAt(i) - 'a'] = newNode;
            parent = parent.children[word.charAt(i) - 'a'];
            i++;
        }
        
        parent.word = word;
        
    }
    
    public void insert(String word) {
        buildTrie(word);
    }
    
    public boolean search(String word) {
        TrieNode parent = root;
        for(char ch:word.toCharArray()) {
            parent = parent.children[ch - 'a'];
            if (parent == null) {
                return false;
            }
        }
        return word.equals(parent.word);        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode parent = root;
        for(char ch:prefix.toCharArray()) {
            parent = parent.children[ch - 'a'];
            if (parent == null) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */