class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int[] counts = new int[26];
        List<Integer> result = new ArrayList<>();
        
        
        for (char ch:p.toCharArray()) {
            counts[ch - 'a']++;
        }
        
        
        int l = 0, r = 0, diff = p.length();
        
        while (r < s.length()) {
            
            
            if (--counts[s.charAt(r) - 'a'] >= 0) {
                diff--;
            }
            r++;
            
            if (diff == 0) {
                result.add(l);
            }
            
            if ((r - l) == p.length()) { //if the window size is reached
                if (counts[s.charAt(l++) - 'a']++ >= 0) { //if the character was present in substring, and match string
                    diff++;
                }
            }
            
        }
        
        return result;
        
    }
}