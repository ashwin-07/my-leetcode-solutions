class Solution {
    
    public void copyArray(char[] sourceArr, char[] destArr, int destStartIdx) {
        for (char ch:sourceArr) {   
            destArr[destStartIdx++] = ch;
        }
    } 
    
    public int compress(char[] chars) {
        int currConseqCount = 1;
        char prevChar = chars[0];
        int compressedCharIdx = 0;
        
        for (int currCharIdx = 1; currCharIdx < chars.length + 1; currCharIdx++) {
            if (currCharIdx < chars.length && prevChar == chars[currCharIdx]) {
                currConseqCount++;
            } 
            else {
               chars[compressedCharIdx++] = prevChar;
               if (currConseqCount > 1) {
                   char[] digits = Integer.toString(currConseqCount).toCharArray();
                   copyArray(digits, chars, compressedCharIdx);
                   compressedCharIdx+=digits.length;
               }
               currConseqCount = 1; 
            }
            prevChar = currCharIdx < chars.length ? chars[currCharIdx]: ' ';
        }    
        return compressedCharIdx;   
    } 

}