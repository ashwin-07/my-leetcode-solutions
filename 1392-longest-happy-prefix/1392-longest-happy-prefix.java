class Solution {
    public String longestPrefix(String s) {
        
        int n = s.length();
        int[] prefixCount = new int[n];
        prefixCount[0] = 0;
        
        for (int i = 0, j = 1; j < n; j++) {
           while (i > 0 && s.charAt(i) != s.charAt(j)) {
                    i = prefixCount[i-1];
            }
            
            if (s.charAt(i) == s.charAt(j)) {
                prefixCount[j] = ++i;
            }
            
        }
        
        return s.substring(0, prefixCount[n-1]);
        
    }
}