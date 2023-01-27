class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {  
        List<String> result = new ArrayList<>();
        
        Set<String> dictionary = new HashSet<>();
        
        Arrays.sort(words, (a,b) -> a.length() - b.length());
   
        for (String word:words) {
            if (canFormWord(dictionary, word)) {
                result.add(word);
            }
            dictionary.add(word);
        }
        
        return result;
 
    }
    
    public boolean canFormWord(Set<String> dictionary, String word) {
        
        boolean[] dp = new boolean[word.length()+1];
         
        if (dictionary.isEmpty()) {
            return false;
        }
        
        dp[0] = true;
        
        for (int i = 1; i <= word.length(); i++) {
            for (int j = i-1; j >= 0; j--) { 
                if (!dp[j]) {
                    continue;
                }
                if (dictionary.contains(word.substring(j,i))) {
                    dp[i] = true;
                    break;
                }    
            }
        } 
        return dp[word.length()];  
    }
}