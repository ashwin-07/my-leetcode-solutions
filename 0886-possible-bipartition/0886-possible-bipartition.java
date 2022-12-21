class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] d : dislikes) {
            int a = d[0] - 1, b = d[1] - 1;
            graph[a].add(b);
            graph[b].add(a);
        }
        int[] groups = new int[n]; 
        Arrays.fill(groups, -1);
        
        for (int i = 0; i < n; i++) {
            
            if (groups[i] == -1 && !dfs(graph, groups, i, 0)) {
                return false;
            }
            
        }
        return true;
        
    }
    
    
    boolean dfs(List<Integer>[] graph, int[] groups, int src, int group) {
        
        if (groups[src] == 1 - group) {
            return false;
        }
        if (groups[src] == group) {
            return true;
        }
        
        groups[src] = group;
        
        for (int i:graph[src]) {
           if (!dfs(graph, groups, i, 1 - group)) {
               return false;
           } 
        }
        
        return true;
        
    }
    
    
}