class Solution {
    public int numberOfArrays(String s, int k) {
        long[] dp = new long[s.length()+1];
        int n = Math.min(String.valueOf(k).length(), String.valueOf(Integer.MAX_VALUE).length());
        dp[0] = 1;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0 && i-j <= n; j--) {
                if (s.charAt(j)=='0') {
                    continue;
                }
                String numStr = s.substring(j, i);
                long num = Long.parseLong(numStr);
                if (num > k) {
                    continue;
                }
                dp[i] = (dp[i] + dp[j]) % 1000000007; 
            }
        }
        return (int)dp[s.length()];
    }
}