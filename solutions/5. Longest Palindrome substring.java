/*
   ID: 15
   Difficulty: Medium
   Description: Given a string s, return the longest palindromic substring in s.
*/


class Solution {
    public String longestPalindrome(String s) {
        
        if (s.length() <= 1) {
            return s;
        }
        
        int start = 0, maxLen = 1;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        for (int i = 0; i < n-1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i+1] = true;
                maxLen = 2;
                start = i;
            }
        }
        
        for (int subLen = 3; subLen <= n; subLen++) {
            for (int i = 0; i <= n - subLen; i++) {
               
                int j = i + subLen - 1;

                if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    
                    if (subLen > maxLen) {
                        start = i;
                        maxLen = subLen;
                    }
                }  
            } 
        }

        return s.substring(start, start + maxLen);
    }
}