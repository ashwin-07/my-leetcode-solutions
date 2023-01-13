class Solution {
    
    int longestPath = 1;
    
    public int longestPath(int[] parent, String s) {
        
        Map<Integer, List<Integer>> graph = constructGraph(parent);
        
        dfsCount(graph, s, 0);
        
        return longestPath;
        
    }
    
    int dfsCount(Map<Integer, List<Integer>> graph, String s, int currNode) {
        
        if (!graph.containsKey(currNode)) {
            return 1;
        }
        
        int longest = 0, secondLongest = 0;
        for (int child:graph.get(currNode)) {
            
            int count = dfsCount(graph, s, child);
            
             if (s.charAt(currNode) == s.charAt(child)) {
                continue;
            }
            
            if (count > longest) {
                secondLongest = longest;
                longest = count;
            }
            else if (count > secondLongest) {
                secondLongest = count;
            }
            
        }
        
        longestPath = Math.max(longestPath, secondLongest + longest + 1);
        return longest+1;
        
    }
    
    
    
    Map<Integer, List<Integer>> constructGraph(int[] parent){
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i < parent.length; i++) {
            graph.computeIfAbsent(parent[i],e -> new ArrayList<Integer>()).add(i);
        }
        return graph;
        
    }
    
}