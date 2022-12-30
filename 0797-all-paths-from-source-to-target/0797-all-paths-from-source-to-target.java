class Solution {
    
    List<List<Integer>> paths = new ArrayList<>();
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        
        List<Integer> path = new ArrayList<>();
        path.add(0);
        
        findPaths(path, graph, 0);
        
        return paths;
        
    }
    
    
    public void findPaths(List<Integer> path, int[][] graph, int node) {
        
        if (node == graph.length - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }
        
        for (int i: graph[node]) {
            path.add(i);
            findPaths(path, graph, i);
            path.remove(path.size() - 1);
        }
        
        
    }
}