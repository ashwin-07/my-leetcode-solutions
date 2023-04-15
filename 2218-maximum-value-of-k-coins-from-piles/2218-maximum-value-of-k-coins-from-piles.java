class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        
        int n = piles.size();
        Integer[][] dp = new Integer[n+1][k+1];
        
        return findMaxVal(piles, dp, 0, k);
        
    }
    
    int findMaxVal(List<List<Integer>> piles, Integer[][] dp, int currIdx, int k) {
        
        if (k == 0 || currIdx >= piles.size()) {
            return 0;
        }
        
        if (dp[currIdx][k] != null) {
            return dp[currIdx][k];
        }
        
        int max = findMaxVal(piles, dp, currIdx+1, k);
        int curSum = 0;
        
        for (int j = 0; j < Math.min(piles.get(currIdx).size(), k); j++) {
            curSum+=piles.get(currIdx).get(j);
            int sumIfCurIsIncluded = findMaxVal(piles, dp, currIdx+1, k - j - 1);
            max = Math.max(max, curSum+sumIfCurIsIncluded);
        }
        
        dp[currIdx][k] = max;
        return max;
        
    }
}