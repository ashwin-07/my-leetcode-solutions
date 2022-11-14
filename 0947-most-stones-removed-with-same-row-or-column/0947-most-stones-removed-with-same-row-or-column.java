class Solution {
    public int removeStones(int[][] stones) {
        if (stones == null || stones.length <= 1);
        int n = stones.length;
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int component = n;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] != stones[j][0] && stones[i][1] != stones[j][1]) {
                    continue;
                }
    
                int rootI = findRoot(parent, i);
                int rootJ = findRoot(parent, j);
                if (rootI == rootJ) { continue; }
                else {
                    parent[rootI] = rootJ;
                    component--;
                }
            }
        }
        return n - component;
    }
    
    private int findRoot(int[] parent, int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}