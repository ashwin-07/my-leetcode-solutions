class Solution {
    int[] parent;
    
    int findParent(int node) {
        return parent[node] == node ? node : 
        (parent[node] = findParent(parent[node]));
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int[] edge:edges) {
            int par1 = findParent(edge[0]);
            int par2 = findParent(edge[1]);
            if (par1 != par2)
                parent[par1] = par2;
        }
        
        return findParent(parent[source]) == findParent(parent[destination]);
        
    }
}