class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        
        HashSet<String> set = new HashSet<>(wordList);
        
        if (!set.contains(endWord)) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            
            while (size-- > 0) {
                
                String currStr = queue.poll();
                if (currStr.equals(endWord)) {
                    return level;
                }
                char[] curr = currStr.toCharArray();
                
                for (int i = 0; i < currStr.length(); i++) {
                    
                    char orgChar = curr[i];
                    
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        curr[i] = ch;
                        String res = String.valueOf(curr);

                        if (set.contains(res)) {
                            queue.offer(res);
                            set.remove(res);
                        }
                        curr[i] = orgChar;
                    }
                    
                }
            }
                level++;
  
        }
        return 0;
       
        
        
    }
}