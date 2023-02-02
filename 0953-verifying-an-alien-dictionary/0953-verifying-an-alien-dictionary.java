class Solution {
    
    public boolean isAlienSorted(String[] words, String order) {
        
        int[] orderArr = new int[26];
        
        for (int i = 0; i < order.length(); i++) {
            orderArr[order.charAt(i) - 'a'] = i;
        }
        
        for (int i = 1; i < words.length; i++) {
            if (isBigger(words[i - 1], words[i], orderArr)) {
                return false;
            }
        }
        
        return true; 
    }
    

    boolean isBigger(String str1, String str2, int[] orderArr) {
        
        int len1 = str1.length(), len2 = str2.length();
        
        for (int i = 0; i < len1 && i < len2; ++i) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return orderArr[str1.charAt(i) - 'a'] > orderArr[str2.charAt(i) - 'a'];
            }
        }
        
        return len1 > len2;
    }
}