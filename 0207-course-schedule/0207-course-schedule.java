class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        // boolean[] hasOccured
        
        if (prerequisites.length == 0) {
            return true;
        }
        
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int before = prerequisites[i][1];
            int dependent = prerequisites[i][0];
            graph[before].add(dependent);
            inDegree[dependent]++;
        }
        
    
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int curr= queue.poll();
            count++;
            for (int i:graph[curr]) {
                if (--inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }

        return count == numCourses;
        
        
    }
}