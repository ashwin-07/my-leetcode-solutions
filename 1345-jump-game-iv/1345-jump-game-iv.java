class Solution {
    public int minJumps(int[] arr) {
        
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            adjMap.computeIfAbsent(arr[i], num -> new ArrayList<>()).add(i);
        }
        
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        int minSteps = 0;
        
        while (!queue.isEmpty()) {
            
            int currLevelSize = queue.size();
            while (currLevelSize-- > 0) {
                
                int currIdx = queue.poll();
                
                if (currIdx == arr.length - 1) {
                    return minSteps;
                }
                
                for (int nextIdx:adjMap.getOrDefault(arr[currIdx], new ArrayList<>())) {
                    if (!visited.contains(nextIdx)) {
                        queue.add(nextIdx);
                        visited.add(nextIdx);
                    }
                }
                
                if (adjMap.containsKey(arr[currIdx])) {
                    adjMap.get(arr[currIdx]).clear();
                }
                
                if (currIdx+1 < arr.length && !visited.contains(currIdx+1)) {
                    queue.add(currIdx+1);
                    visited.add(currIdx+1);
                }
                if (currIdx-1 > 0 && !visited.contains(currIdx-1)) {
                    queue.add(currIdx-1);
                    visited.add(currIdx-1);
                } 
            }
            minSteps++;
        }
        
        return minSteps;
        
        
    }
}


