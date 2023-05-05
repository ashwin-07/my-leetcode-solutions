class Solution {
    
    final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');
    
    public int maxVowels(String s, int k) {
        int totalVowelsCount = 0;
        for(int i =0; i< k; i++) {
            if(VOWELS.contains(s.charAt(i))) {
                totalVowelsCount++;
            } 
        }
        
        int maxCount = totalVowelsCount;
        
        for(int i = k; i < s.length(); i++) {
            if(VOWELS.contains(s.charAt(i))) {
                totalVowelsCount++;
            }
            if(VOWELS.contains(s.charAt(i-k))) {
                totalVowelsCount--;
            }
            maxCount = Math.max(maxCount, totalVowelsCount);
        }
        
        return maxCount;
    }
}