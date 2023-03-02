class Solution {
    
    public void copyArray(char[] sourceArr, char[] destArr, int destStartIdx) {
        for (char ch:sourceArr) {   
            destArr[destStartIdx++] = ch;
        }
    } 
    
    public int compress(char[] chars) {
        
        int currConseqCount = 1;
        char prevChar = chars[0];
        int idx = 0;
        
        for (int i = 1; i < chars.length + 1; i++) {
            if (i < chars.length && prevChar == chars[i]) {
                currConseqCount++;
            } 
            else {
               chars[idx++] = prevChar;
               if (currConseqCount > 1) {
                   char[] digits = Integer.toString(currConseqCount).toCharArray();
                   copyArray(digits, chars, idx);
                   idx+=digits.length;
               }
               currConseqCount = 1; 
            }
            prevChar = i < chars.length ? chars[i]: ' ';
        }
        
        return idx;   
    } 

}