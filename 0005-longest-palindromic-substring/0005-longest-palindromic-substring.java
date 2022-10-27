class Solution {
    
    int start, maxLen;
    
    public String longestPalindrome(String s) {
        
        
        if (s.length() < 2) {
            return s;
        }
        
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i); //odd length string
            expand(s, i,i+1); //even length string
        }
        
        return s.substring(start, start+maxLen);
        
        
        
    }
    
    
    void expand(String s, int low, int hi) {
        
       while (low >= 0 && hi < s.length() && s.charAt(low) == s.charAt(hi)) {
           low--;
           hi++;
       } 
        
       if (hi - low - 1 > maxLen) {
           maxLen = hi - low - 1;
           start = low + 1;
       } 
        
    }
}