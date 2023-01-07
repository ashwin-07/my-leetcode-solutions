class Solution {
    public String alienOrder(String[] words) {
        
        Map<Character, Set<Character>> adjMap = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        
        //initialize the maps
        for (String word:words) {
            for (char ch:word.toCharArray()) {
                degree.put(ch, 0);
                adjMap.put(ch, new HashSet<>());
            }
        }
        
        boolean isBuildGraphSuccess = buildGraph(adjMap, degree, words);
        
        if (!isBuildGraphSuccess) {
            return "";
        }
        
        //topological sort (using bfs)
        
        Queue<Character> queue = new LinkedList<>();
        for (char ch:degree.keySet()) {
            if (degree.get(ch) == 0) {
                queue.add(ch);
            }
        }
        
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            
            char currChar = queue.poll();
            result.append(currChar);
            
            for (char ch: adjMap.get(currChar)) {
                degree.put(ch, degree.get(ch)-1);
                if (degree.get(ch) <= 0) {
                    queue.add(ch);
                }
            }
            
        }
        
        return result.length() == degree.size()? result.toString() : "";
        
        
    }
    
    boolean buildGraph(Map<Character, Set<Character>> adjMap, Map<Character, Integer> degree, String[] words) {
        
        for (int i = 0; i < words.length - 1; i++) {
            
            String word1 = words[i];
            String word2 = words[i+1];
            
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return false;
            }
            
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                
                if (word1.charAt(j) != word2.charAt(j)) {  
                    if (!adjMap.get(word1.charAt(j)).contains(word2.charAt(j))) {
                        degree.put(word2.charAt(j), degree.get(word2.charAt(j)) + 1);
                        adjMap.get(word1.charAt(j)).add(word2.charAt(j));
                    }
                    break;
                }
                
            }
            
        }
        
        return true;
        
    }
}


