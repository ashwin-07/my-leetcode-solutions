class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        
        int start = 0, max = 0, maxLen = 0;
        
        for (int end = 0; end < n; end++) {
            
            max = Math.max(max, ++count[s.charAt(end) - 'A']);
            
            if (end - start - max + 1 > k) {
                --count[s.charAt(start) - 'A'];
                start++;
                max = 0;
            }
            
            maxLen = Math.max(maxLen, end - start +1);  
            
        }
        
        return maxLen;
    }
}