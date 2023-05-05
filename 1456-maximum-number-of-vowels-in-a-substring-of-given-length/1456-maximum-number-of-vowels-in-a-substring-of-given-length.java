class Solution {
    
    // final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');
    
    private boolean isVowel(char c){
        if((c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) return true;
        return false;
    }
    
    public int maxVowels(String s, int k) {
        int totalVowelsCount = 0;
        for(int i =0; i< k; i++) {
            if(isVowel(s.charAt(i))) {
                totalVowelsCount++;
            } 
        }
        
        int maxCount = totalVowelsCount;
        
        for(int i = k; i < s.length(); i++) {
            if(isVowel(s.charAt(i))) {
                totalVowelsCount++;
            }
            if(isVowel(s.charAt(i-k))) {
                totalVowelsCount--;
            }
            maxCount = Math.max(maxCount, totalVowelsCount);
        }
        
        return maxCount;
    }
}