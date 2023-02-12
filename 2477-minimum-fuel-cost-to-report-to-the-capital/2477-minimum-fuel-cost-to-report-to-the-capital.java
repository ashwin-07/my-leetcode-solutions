class Solution {
    
    long totalFuel;


    public long minimumFuelCost(int[][] roads, int seats) {
        
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        
        for (int[] road : roads) {
            adjMap.computeIfAbsent(road[0], ele -> new ArrayList<Integer>()).add(road[1]);
            adjMap.computeIfAbsent(road[1], ele -> new ArrayList<Integer>()).add(road[0]);
        }
        
        dfsAndCount(0, -1, adjMap, seats);
        return totalFuel;
    }
    

    public long dfsAndCount(int currNode, int prevNode,
                            Map<Integer, List<Integer>> adjMap, int seats) {
        
        int nodeCounts = 1;
        
        if (!adjMap.containsKey(currNode)) {
            return nodeCounts;
        }
        
        for (int child : adjMap.get(currNode)) {
            if (child != prevNode) {
                nodeCounts += dfsAndCount(child, currNode, adjMap, seats);
            }
        }
        
        if (currNode != 0) {
            totalFuel += Math.ceil((double) nodeCounts / seats);
        }
        
        return nodeCounts;
    }
    
}