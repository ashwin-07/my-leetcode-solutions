class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        if (edges.length != n-1) {
            return false;
        }
        
        List<List<Integer>> adjList = new ArrayList<>();
        
        IntStream.range(0, n).forEach(idx -> adjList.add(new ArrayList<>()));
        
        for (int[] edge:edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.offer(0);
        visited.add(0);
        
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            for (int child:adjList.get(currNode)) {
                
                if (visited.contains(child)) {
                    continue;
                }
                queue.add(child);
                visited.add(child);
       
            }
            
        }
        
        return visited.size() == n;
        
    }
}