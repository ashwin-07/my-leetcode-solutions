class Solution {
    
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        buildGraph(graph, edges);
        
        Set<Integer> visited = new HashSet<>();
        
        return dfsComputeTime(graph, hasApple, visited, 0);     
    }
    
    public int dfsComputeTime(Map<Integer, List<Integer>> graph, List<Boolean> hasApple,
                              Set<Integer> visited, int node) {         
        visited.add(node);
        
        int timeTaken = 0;
        
        for (int child:graph.get(node)) {
            if (visited.contains(child)) {
                continue;
            }
            timeTaken+=dfsComputeTime(graph, hasApple, visited, child);
        }
        
        if (((timeTaken > 0) || hasApple.get(node)) && node != 0) {
            timeTaken+=2;
        }
        
        return timeTaken; 
    }
 
    
    public void buildGraph(Map<Integer, List<Integer>> graph, int[][] edges) {
        
        for (int[] edge:edges) {  
            int a = edge[0], b = edge[1];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }        
    }
}