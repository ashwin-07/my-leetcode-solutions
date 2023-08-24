class Solution {
    public boolean repeatedSubstringPattern(String s) {
        
        int strLen = s.length();
        
        for (int i = strLen/2; i >= 1; i--) {
            
            if (strLen%i == 0) {
                int size = strLen/i;
                
                String substr = s.substring(0, i);
                StringBuilder formedStr = new StringBuilder();
                for (int k = 0; k < size; k++) {
                    formedStr.append(substr);
                }
                
                if (formedStr.toString().equals(s)) {
                    return true;
                }   
            }
        }
        
        return false;
    }
}