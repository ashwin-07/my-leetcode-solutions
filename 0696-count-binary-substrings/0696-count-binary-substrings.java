class Solution {
    public int countBinarySubstrings(String s) {
     
        int prevCount = 0, currCount = 1, res = 0;
        
        for (int i = 1; i < s.length(); i++) {
            
            if (s.charAt(i) == s.charAt(i-1)) currCount++;
            else {
                prevCount = currCount;
                currCount = 1;
            }
            
            if (currCount <= prevCount) res++;
            
        }
        
        return res;
        
    }
}