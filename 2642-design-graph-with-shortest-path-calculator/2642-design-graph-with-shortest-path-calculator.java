class Graph {
    
    class NodeDetails {
        int node;
        int cost;
        
        NodeDetails(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    
    List<List<NodeDetails>> adjList;

    public Graph(int n, int[][] edges) {
        
        initializeAdjList(n);
        for (int[] e : edges) {
            adjList.get(e[0]).add(new NodeDetails(e[1], e[2]));
        } 
    }
    
    private void initializeAdjList(int n) {
       adjList = new ArrayList<>();
       for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
    }
    
    public void addEdge(int[] edge) {
        adjList.get(edge[0]).add(new NodeDetails(edge[1], edge[2]));
    }
    
    public int shortestPath(int node1, int node2) {
        
        int n = adjList.size();
        Queue<NodeDetails> minHeap = new PriorityQueue<NodeDetails>(Comparator.comparingInt(details -> details.cost));
        int[] nodeCost = new int[n];
        Arrays.fill(nodeCost, Integer.MAX_VALUE);
        nodeCost[node1] = 0;
        minHeap.offer(new NodeDetails(node1, 0));
        
        while (!minHeap.isEmpty()) {
            NodeDetails currNodeDetails = minHeap.poll();

            if (currNodeDetails.cost > nodeCost[currNodeDetails.node]) {
                continue;
            }
            if (currNodeDetails.node == node2) {
                return currNodeDetails.cost;
            }
            for (NodeDetails neighbor : adjList.get(currNodeDetails.node)) {
                int newCost = currNodeDetails.cost + neighbor.cost;
                if (newCost < nodeCost[neighbor.node]) {
                    nodeCost[neighbor.node] = newCost;
                    minHeap.offer(new NodeDetails(neighbor.node,newCost));
                }
            }
        }

        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */