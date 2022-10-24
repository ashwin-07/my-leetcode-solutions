class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if (strs.length == 0) {
            return new ArrayList();
        }
        
        Map<String, List<String>> occurence = new HashMap<>();
        
        
        for (String s:strs) {
            int[] count = new int[26];
            for (char c:s.toCharArray()) {count[c - 'a']++;}
            
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < 26; i++){
                if (count[i] > 0) {
                    sb.append((char)('a'+i) +"" + count[i]);
                }
            }
            
            String key = sb.toString();
            if (!occurence.containsKey(key)) 
                occurence.put(key, new ArrayList<>());
            
            occurence.get(key).add(s);
            
        }
        
        
        return new ArrayList(occurence.values());
        
    }
}