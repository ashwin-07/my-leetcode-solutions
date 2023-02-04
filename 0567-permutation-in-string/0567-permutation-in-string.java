class Solution {
    
    public boolean checkInclusion(String s1, String s2) {
        
        HashMap<Character,Integer> s1CharCountMap = new HashMap<>();
        
        for (char ch:s1.toCharArray()) {
            s1CharCountMap.put(ch, s1CharCountMap.getOrDefault(ch, 0)+1);
        }
        
        int currIdx = 0;
        int formedLen = 0;
        
        while (currIdx < s2.length()) {
            
            char currChar = s2.charAt(currIdx);
            if (s1CharCountMap.containsKey(currChar)) {
                int countForChar = s1CharCountMap.get(currChar) - 1;
                s1CharCountMap.put(currChar, countForChar);
                if (countForChar == 0) {
                    formedLen++;
                }
            }
            if (currIdx >= s1.length()) {
                char charOutSideWindow = s2.charAt(currIdx - s1.length());
                if (s1CharCountMap.containsKey(charOutSideWindow)) {
                    if (s1CharCountMap.get(charOutSideWindow) == 0) {
                      formedLen--;  
                    }
                    s1CharCountMap.put(charOutSideWindow,
                                             s1CharCountMap
                                             .get(charOutSideWindow) + 1);
                } 
            }
            
            if (formedLen == s1CharCountMap.size()) {
                return true;
            }

            currIdx++;
        }
        
        return false;
        
    }
}