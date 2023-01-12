class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        
        Map<Integer, List<Integer>> graph = buildGraph(edges);
        int[] counts = new int[n];
        
        Set<Integer> visited = new HashSet<>();
        findCounts(0, visited, graph, labels.toCharArray(), counts);
        return counts;
    }
    
    
    public int[] findCounts(int node,
                          Set<Integer> visited,
                          Map<Integer, List<Integer>> graph,
                          char[] labels,
                          int[] result
                         ) {
        
        int[] counts = new int[26];
        if (visited.contains(node)) {
            return counts;
        }
        else {
            visited.add(node);
            for (int child:graph.get(node)) {
                
                int[] childCounts = findCounts(child, visited, graph, labels, result);
                int childRes = 0;
                
                for (int i = 0; i < 26; i++) {
                    counts[i]+= childCounts[i];
                }
                
            }
            
            ++counts[labels[node] - 'a'];
            result[node] = counts[labels[node] - 'a'];
            return counts; 
        }
        
    }
    
    
    
    
    Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        
         Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int[] edge:edges) {  
            graph.computeIfAbsent(edge[0], e -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], e -> new ArrayList<>()).add(edge[0]);
        }
        
        return graph;
        
    }
    
}