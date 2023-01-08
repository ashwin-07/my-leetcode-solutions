class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> occurence = new HashMap<>();
        
        int maxLen = 0;
        int start = 0;
    
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (occurence.containsKey(ch) && occurence.get(ch)  > start) {
                start = occurence.get(ch);
            }
            maxLen = Math.max(maxLen, i - start + 1);
            occurence.put(ch, i+1);   
        }
        
        return maxLen;
    }
}