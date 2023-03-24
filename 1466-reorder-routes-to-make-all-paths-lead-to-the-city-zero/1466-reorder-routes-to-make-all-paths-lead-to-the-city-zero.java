class Solution {
    
    int count = 0;
    
    class RouteDetails {
        int node;
        int direction;
        
        RouteDetails(int node, int direction) {
            this.node = node;
            this.direction = direction;
        }
        
    } 

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<RouteDetails>> graph = buildGraph(n, connections);
        dfs(0, -1, graph);
        return count;
    }
    
    void dfs(int node, int parent, Map<Integer, List<RouteDetails>> graph) {
        if (!graph.containsKey(node)) {
            return;
        }
        for (RouteDetails neighbour : graph.get(node)) {
            int neighbourNode = neighbour.node;
            int direction = neighbour.direction;
            if (neighbourNode != parent) {
                count += direction;
                dfs(neighbourNode, node, graph);
            }
        }
    }
    
    
    Map<Integer, List<RouteDetails>> buildGraph(int n, int[][] connections) {       
        Map<Integer, List<RouteDetails>> graph = new HashMap<>();
        
        for (int[] connection: connections) {
            graph.computeIfAbsent(connection[0], e -> new ArrayList<>())
                .add(new RouteDetails(connection[1], 1));
            
            graph.computeIfAbsent(connection[1], e -> new ArrayList<>())
                .add(new RouteDetails(connection[0], 0));
        }
        
        return graph;
    }
}