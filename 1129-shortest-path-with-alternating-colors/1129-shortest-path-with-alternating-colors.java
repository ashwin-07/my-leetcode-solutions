class Solution {
    
    class NodeDetails {
        
        int nodeColour;
        int distance;
        int nodeVal;
        
        NodeDetails(int nodeVal, int nodeColour, int distance) {
            this.nodeVal = nodeVal;
            this.nodeColour = nodeColour;
            this.distance = distance;
        }
        
        void setDistance(int distance) {
            this.distance = distance;
        }
    }
    
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        Set<Integer> blueVisited = new HashSet<>();
        Set<Integer> redVisited = new HashSet<>();
        
        int[] distances = new int[n];
        Arrays.fill(distances, -1);
        
        Queue<NodeDetails> queue = new LinkedList<>();
        
        Map<Integer, List<NodeDetails>> adjList = new HashMap<>();
        
        for (int[] edge:redEdges) {
            adjList.computeIfAbsent(edge[0], e -> new ArrayList<>()).add(new NodeDetails(edge[1], 0, 0));
        }
        
        for (int[] edge:blueEdges) {
            adjList.computeIfAbsent(edge[0], e -> new ArrayList<>()).add(new NodeDetails(edge[1], 1, 0));
        }
        
        queue.add(new NodeDetails(0, -1, 0));
        
        blueVisited.add(0);
        redVisited.add(0);
        
        distances[0] = 0;
        
        
        while (!queue.isEmpty()) {
            
            NodeDetails currNode = queue.poll();
            
            if (!adjList.containsKey(currNode.nodeVal)) {
                continue;
            }
            
            for (NodeDetails neighbour: adjList.get(currNode.nodeVal)) {
                
                int nodeColour = neighbour.nodeColour;
                boolean isVisited = nodeColour == 1? blueVisited.contains(neighbour.nodeVal) : redVisited.contains(neighbour.nodeVal);
                int newDistance = 1 + currNode.distance;
                
                if ((nodeColour != currNode.nodeColour) && !isVisited) {
                    
                    neighbour.setDistance(newDistance);
                    
                    if (distances[neighbour.nodeVal] == -1) {
                        distances[neighbour.nodeVal] = neighbour.distance;
                    }
                    
                    if (nodeColour == 1) {
                        blueVisited.add(neighbour.nodeVal);
                    } else {
                        redVisited.add(neighbour.nodeVal);
                    }
                      
                    queue.add(neighbour);
                    
                }
                
            }
            
        }
        
        return distances;
    }
}
