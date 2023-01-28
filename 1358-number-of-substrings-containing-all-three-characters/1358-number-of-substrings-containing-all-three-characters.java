class Solution {
    public int numberOfSubstrings(String s) {
        
        int[] counts = new int[3];
        
        int hi = 0, lo = 0;
        
        int result = 0;
        
        while (hi < s.length()) {
            counts[s.charAt(hi) - 'a']++;
            
            while (counts[0] > 0 && counts[1] > 0 && counts[2] > 0) {
                --counts[s.charAt(lo) - 'a'];
                lo++;
                result+=(s.length() - hi);
            }
            hi++;
        }
        
        return result;
    }
}