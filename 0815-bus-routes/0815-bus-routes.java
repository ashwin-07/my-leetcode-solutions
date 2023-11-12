class Solution {
    
    private Map<Integer, ArrayList<Integer>> buildAdjList(int[][] routes) {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for (int rIdx = 0; rIdx < routes.length; rIdx++) {
            for (int route : routes[rIdx]) {
                ArrayList<Integer> routeNodeList = adjList.getOrDefault(route, new ArrayList<>());
                routeNodeList.add(rIdx);
                adjList.put(route, routeNodeList);
            }
        }
        return adjList;
    }
    
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if (source == target) {
            return 0;
        }

        Map<Integer, ArrayList<Integer>> adjList = buildAdjList(routes);
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedSet = new HashSet<Integer>();
        
        for (int node : adjList.get(source)) {
            queue.add(node);
            visitedSet.add(node);
        }
        
        int busesCount = 1;
        
        //bfs
        while (!queue.isEmpty()) {
            int currLvlSize = queue.size();
            for (int i = 0; i < currLvlSize; i++) {
                int currStop = queue.remove();
                for (int route: routes[currStop]) {
                    if (route == target) {
                        return busesCount;
                    }

                    for (int nextStop : adjList.get(route)) {
                        if (!visitedSet.contains(nextStop)) {
                            queue.add(nextStop);
                            visitedSet.add(nextStop);
                        }
                    }
                }
            }
            busesCount++;
        }
        return -1;
        
    }
}