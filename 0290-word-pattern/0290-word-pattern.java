class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        Map<Character, String> charWordMapping = new HashMap<>();
        
        String[] words = s.split(" ");
        
        if (words.length != pattern.length()) {
            return false;
        }
        
        
        for (int i = 0; i < words.length; i++) {
            
            char ch = pattern.charAt(i);
            
            if (charWordMapping.containsKey(ch)) {
                
                if (!charWordMapping.get(ch).equals(words[i])) {
                    return false;
                }
                
            }
            else {
               
                if (charWordMapping.containsValue(words[i])) {
                    return false;
                }
                
               charWordMapping.put(ch, words[i]); 
            }
            
            
        }
        
        return true;
        
        
    }
}