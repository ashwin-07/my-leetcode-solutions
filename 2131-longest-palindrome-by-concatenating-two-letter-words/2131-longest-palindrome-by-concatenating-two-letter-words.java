class Solution {
    public int longestPalindrome(String[] words) {
        
        Map<String, Integer> wordOccurenceMap = new HashMap<>();
        
        int maxLength = 0;
        
        for (String word: words) {
            
            String reversedWord = word.charAt(1)+""+word.charAt(0);
            
            if (wordOccurenceMap.containsKey(reversedWord)) {
                
              maxLength+=4;
              wordOccurenceMap.put(reversedWord, wordOccurenceMap.get(reversedWord) - 1);
              if (wordOccurenceMap.get(reversedWord) == 0) {
                  wordOccurenceMap.remove(reversedWord);
              }  
                 
            } 
            else {
                 wordOccurenceMap.put(word, (wordOccurenceMap.getOrDefault(word, 0)+1));
            }  
           
        }
        
        //to handle same chars words which can be added to middle of reversed words
        //gg, ff, hh..  EX: lcGGcl
        for (String word: wordOccurenceMap.keySet()) {
            if (word.charAt(0) == word.charAt(1)) {
               maxLength+=2;
               break;
            }
        }
        
        
        
        return maxLength;
    }
}