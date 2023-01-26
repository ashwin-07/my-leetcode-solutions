class Solution {
    
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int[] flight:flights) {
            graph.computeIfAbsent(flight[0], val -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }
        
        int[] stops = new int[n];
        
        Arrays.fill(stops, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0],b[0]));
        
        queue.offer(new int[]{0, src, 0});
        
        while (!queue.isEmpty()) {
            
            int[] currDetails = queue.poll();
            int dist = currDetails[0];
            int node = currDetails[1];
            int steps = currDetails[2];
            
            if (steps > stops[node] || steps > K + 1)
                continue;
            
            if (node == dst)
                return dist;
            
            stops[node] = steps;
            
            if (!graph.containsKey(node)) {
                continue;
            }
            
            for (int[] child : graph.get(node)) {
                queue.offer(new int[] { dist + child[1], child[0], steps + 1 });
            }
            
        }
        
        return -1;
        
    }
}