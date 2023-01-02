class Solution {
    public boolean detectCapitalUse(String word) {
        
        if (word.length() == 1) {
            return true;
        }
        
        boolean isFirstCharUpperCase = Character.isUpperCase(word.charAt(0));
        int upperCaseCount = 0;
        
        for (char ch:word.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upperCaseCount++;
            }
        }
        
        return isFirstCharUpperCase ? (upperCaseCount == word.length() || upperCaseCount == 1) :
                                      (upperCaseCount == 0);
        
    }
    
    
}