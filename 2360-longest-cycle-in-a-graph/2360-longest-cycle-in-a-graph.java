class Solution {
    
    int longestCycleLength = -1;
    
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Map<Integer, Integer> nodeDistanceMap = new HashMap<>();
                nodeDistanceMap.put(i, 1);
                dfs(i, edges, nodeDistanceMap, visited);
            }
        }
        
        return longestCycleLength;
    }

    public void dfs(int node, int[] edges, Map<Integer, Integer> nodeDistanceMap, boolean[] visited) {
        visited[node] = true;
        int neighbor = edges[node];

        if (neighbor != -1 && !visited[neighbor]) {
            nodeDistanceMap.put(neighbor, nodeDistanceMap.get(node) + 1);
            dfs(neighbor, edges, nodeDistanceMap, visited);
        } 
        else if (neighbor != -1 && nodeDistanceMap.containsKey(neighbor)) {
            int currDistance = nodeDistanceMap.get(node) - nodeDistanceMap.get(neighbor);
            longestCycleLength = Math.max(longestCycleLength, currDistance + 1);
        }
    }
    
}