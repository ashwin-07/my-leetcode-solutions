class Solution {
    
    public long countPairs(int n, int[][] edges) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], e -> new ArrayList<Integer>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], e -> new ArrayList<Integer>()).add(edge[0]);
        }

        long remainingNodes = n;
        long unConnectedPairsCount = 0;
        
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int noOfConnectedNodes = dfs(graph, i, visited);
                unConnectedPairsCount += noOfConnectedNodes * (remainingNodes - noOfConnectedNodes);
                remainingNodes -= noOfConnectedNodes;
            }
        }
        return unConnectedPairsCount;
    }
    
    
    int dfs(Map<Integer, List<Integer>> graph, int node, boolean[] visited) {
        
        int connectedCount = 1;
        visited[node] = true;
        
        if (!graph.containsKey(node)) {
            return connectedCount;
        }
        
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                connectedCount += dfs(graph, neighbor, visited);
            }
        }
        return connectedCount;
    }
}



    
    