class Solution {
    
        
    long calculateEucledianDist(int x1, int x2, int y1, int y2) {
        return (long)(x1 - x2) * (x1 - x2) + (long)(y1 - y2) * (y1 - y2);
    }
        
    
    Map<Integer, List<Integer>> buildAdjGraph(int[][] bombs) {
        int n = bombs.length;
        Map<Integer, List<Integer>> adjGraph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
                int x2 = bombs[j][0], y2 = bombs[j][1];
                
                if ((long)r1 * r1 >= calculateEucledianDist(x1,x2,y1,y2)) {
                    adjGraph.computeIfAbsent(i, e -> new ArrayList<>()).add(j);
                }
            }
        }
        return adjGraph;
    }
    
    int bfs(int i, Map<Integer, List<Integer>> adjGraph) {
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(i);
        visited.add(i);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nextNode : adjGraph.getOrDefault(cur, new ArrayList<>())) {
                if (!visited.contains(nextNode)) {
                    visited.add(nextNode);
                    queue.offer(nextNode);
                }
            }
        }
        return visited.size();
    }
    
    public int maximumDetonation(int[][] bombs) {
        
        int n = bombs.length;
        Map<Integer, List<Integer>> adjGraph = buildAdjGraph(bombs);
        
        int maxDistance = 0; //max number of detonationations a node(bomb) can make
        for (int i = 0; i < n; i++) {
            maxDistance = Math.max(maxDistance, bfs(i, adjGraph));
        }
        
        return maxDistance;   
        
    }


}