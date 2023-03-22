class Solution {
    public int minScore(int n, int[][] roads) {
        
        Map<Integer, Map<Integer, Integer>> adjGraph = new HashMap<>();
        
        for (int[] road : roads) {
            int src = road[0];
            int to = road[1];
            int weight = road[2];
            adjGraph.computeIfAbsent(src, k -> new HashMap<>()).put(to, weight);
            adjGraph.computeIfAbsent(to, k -> new HashMap<>()).put(src, weight);
        }
        
        int result = Integer.MAX_VALUE;
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (Map.Entry<Integer, Integer> entry : adjGraph.get(node).entrySet()) {    
                int adj = entry.getKey(), score = entry.getValue();
                if (!visited.contains(adj)) {
                    queue.offer(adj);
                    visited.add(adj);
                }
                result = Math.min(result, score);
            }
        }
        
        return result;
    }
}