class Solution {
    
    public int makeConnected(int n, int[][] connections) {
        
        if (connections.length < n - 1) {
            return -1;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];
        int totalConnectedComponents = 0;
        
        for (int[] connection: connections) {
            graph.computeIfAbsent(connection[0], e -> new ArrayList<Integer>()).add(connection[1]);
            graph.computeIfAbsent(connection[1], e -> new ArrayList<Integer>()).add(connection[0]); 
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                totalConnectedComponents++;
                dfs(graph, i, visited);
            }
        }

        return totalConnectedComponents - 1;   
    }
    
    
    public void dfs(Map<Integer, List<Integer>> graph, int node, boolean[] visited) {
        
        visited[node] = true;
        if (!graph.containsKey(node)) {
            return;
        }
        
        for (int neighbour: graph.get(node)) {
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                dfs(graph, neighbour, visited);
            }
        }
    }
}