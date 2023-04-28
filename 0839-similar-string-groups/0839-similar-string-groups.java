class Solution {
    
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int numGroups = n;
        int[] parent = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(isSimilar(strs[i], strs[j])) {
                    int parent1 = find(i, parent);
                    int parent2 = find(j, parent);
                
                    if(parent1 != parent2){
                        parent[parent2] = parent1;
                        numGroups--;    
                    }
                }    
            }
        }
        
        return numGroups;
    }
    
    int find(int node, int[] parent){
        if(parent[node] == node){
            return node;
        } 
        
        return parent[node] = find(parent[node], parent);
    }
    
    boolean isSimilar(String s1, String s2) {
        
        int mismatch = 0;
        
        for(int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                mismatch++;
            }
            if (mismatch > 2) {
                return false;
            }
        }
        
        return true;
    }
}