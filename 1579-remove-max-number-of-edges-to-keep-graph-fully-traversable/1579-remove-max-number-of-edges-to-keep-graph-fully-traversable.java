class Solution {
    public int find(int node , int[] parent){
        if(parent[node] == node)
            return node;
        parent[node] = find(parent[node] , parent);
        return parent[node];
    }

    public boolean union(int node1 , int node2 , int[] parent , int[] rank){
        int parent1 = find(node1 , parent);
        int parent2 = find(node2 , parent);

        if(parent1 != parent2){
            if(rank[parent1] > rank[parent2])
                parent[parent2] = parent1;
            else if(rank[parent2] > rank[parent1])
                parent[parent1] = parent2;
            else{
                parent[parent2] = parent1;
                rank[parent1]++;
            }
            return true;
        }
        return false;
    }
    
    public int maxNumEdgesToRemove(int n, int[][] edges)
    {
        Arrays.sort(edges , (a,b) -> b[0] - a[0]);

        int[] parents1 = new int[n+1];
        int[] parents2 = new int[n+1];

        int[] ranks1 = new int[n+1];
        int[] ranks2 = new int[n+1];

        for(int i=0;i<n+1;i++){
            parents1[i] = i;
            parents2[i] = i;
            ranks1[i] = 1;
            ranks2[i] = 1;
        }

        int merged1 = 1, merged2 = 1, remove = 0;

        for(int[] edge : edges){
            if(edge[0] == 3){
                boolean union1 = union(edge[1] , edge[2] , parents1 , ranks1);
                boolean union2 = union(edge[1] , edge[2] , parents2 , ranks2);

                if(union1 == true)
                    merged1++;
                if(union2 == true)
                    merged2++;
                if(union1 == false && union2 == false)
                    remove++;
            }
            else if(edge[0] == 1){
                boolean union1 = union(edge[1] , edge[2] , parents1 , ranks1);
                if(union1 == true)
                    merged1++;
                else
                    remove++;
            }
            else{
                boolean union2 = union(edge[1] , edge[2] , parents2 , ranks2);
                if(union2 == true)
                    merged2++;
                else
                    remove++;
            }

        }
        if(merged1 != n || merged2 != n)
            return -1;
        return remove;
    }
}