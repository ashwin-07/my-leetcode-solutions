class Solution {
    
    Map<String, List<String>> cache = new HashMap<>();
    
     public List<String> wordBreak(String s, List<String> wordDict) {
         return wordBreak(s, new HashSet<>(wordDict));
     }
    
    public List<String> wordBreak(String s, Set<String> wordDict) {
     
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        
        if (wordDict.contains(s)) {
            result.add(s); 
        }
        
        
        for (int i = 1; i < s.length(); i++) {
            String newS = s.substring(i);
            
            if (wordDict.contains(newS)) {
                List<String> subRes = wordBreak(s.substring(0, i), wordDict);
                if (subRes.size() > 0) {
                    for (String str:subRes) {
                        result.add(str+" "+newS);
                    }
                }
            }
        }
        
        cache.put(s, result);
        
        return result;
        
        
    }
}