class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character, Integer> tOccurences = new HashMap<Character, Integer>();
        
        for (char c:t.toCharArray()){
            tOccurences.put(c, tOccurences.getOrDefault(c, 0) + 1);
        }
        
        int req = tOccurences.size();
        
        int minLen = -1, resL=0, resR=0;
        int l = 0, r = 0;
        
        Map<Character, Integer> windowOccurences = new HashMap<Character, Integer>();
        
        int formed = 0;
        
        while (r < s.length()) {
            
            char curr = s.charAt(r);
            
            windowOccurences.put(curr, windowOccurences.getOrDefault(curr, 0)+1);
            
            if (tOccurences.containsKey(curr) && windowOccurences.get(curr).intValue() == tOccurences.get(curr).intValue()) {
                formed++;
            }
            
            while (l <= r && formed == req) {
                curr = s.charAt(l);
                // if (l <= r && formed == req) {
                    if (minLen == -1 || r - l + 1 < minLen) {
                        minLen = r - l + 1;
                        resL = l;
                        resR = r;
                    // }
                }

                l++;
                
                windowOccurences.put(curr, windowOccurences.get(curr)-1);
                if (tOccurences.containsKey(curr) && windowOccurences.get(curr).intValue() < tOccurences.get(curr).intValue()) {
                    formed--;
                }
            }
            r++;
        }
        
        return minLen == -1 ? "" : s.substring(resL, resR+1);
        
    }
}