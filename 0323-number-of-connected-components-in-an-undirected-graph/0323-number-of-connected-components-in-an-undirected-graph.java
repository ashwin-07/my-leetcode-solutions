class Solution {
    
    
    int find(int[] parent, int node) {  
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }
    
    int union(int[] parent, int[] rank, int n1, int n2) {
      int par1 = find(parent, n1);
      int par2 = find(parent, n2);
            
      if (par1 != par2) {
        if (rank[par1] > rank[par2]) {
            parent[par2] = par1;
            rank[par1]+=rank[par2];    
        }
        else {
            parent[par1] = par2;
            rank[par2]+=rank[par1];  
        }  
        return 1;   
      }
      return 0;  
    }
    
    public int countComponents(int n, int[][] edges) {
        
        int[] parent = new int[n];
        int[] rank = new int[n];
        
        int numOfComponents = n;
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        for (int[] edge:edges) { 
            numOfComponents-=union(parent, rank, edge[0], edge[1]); 
        }
        
        return numOfComponents;
        
    }
}