class Solution {
    public int findJudge(int n, int[][] trusts) {
      
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];
        
        for (int[] trust:trusts) {
            inDegree[trust[1]-1]++;
            outDegree[trust[0]-1]++;
        }
        
        int candidate = -1;
        
        for (int i = 0; i < n; i++) {
            
            if (inDegree[i] == n-1 && outDegree[i] == 0) {
                if (candidate == -1) {
                    candidate = i+1;
                }
                else {
                    return -1;
                }
            }
            
        }
        
        return candidate;
        
    }
}