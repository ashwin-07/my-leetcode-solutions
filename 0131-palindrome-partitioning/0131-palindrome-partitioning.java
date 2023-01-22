class Solution {
    public List<List<String>> partition(String s) {
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        
        findAllPartitions(result, s, 0, new ArrayList<>(), dp);
        
        return result;
        
    }
    
    
    void findAllPartitions(List<List<String>> result, String s, int start, List<String> currRes, boolean[][] dp) {
        
        if (start >= s.length()) {
            result.add(new ArrayList<>(currRes));
        }
        
        for (int end = start; end < s.length(); end++) {
            
            if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start+1][end - 1])) {
                dp[start][end] = true;
                currRes.add(s.substring(start, end+1));
                findAllPartitions(result, s, end+1, currRes, dp);
                currRes.remove(currRes.size() - 1);
            }
            
        }
        
        
    }
    
}