class Solution {
    public String convert(String s, int numRows) {
        
        int strLen = s.length();
        StringBuffer[] sb = new StringBuffer[numRows];
        
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuffer();
        }

        int i = 0;
        while (i < strLen) {
            
            for (int j = 0; j < numRows && i < strLen; j++) {
                sb[j].append(s.charAt(i++));
            }
            
            for (int j = numRows-2; j >= 1 && i < strLen; j--) {
                sb[j].append(s.charAt(i++));
            }
            
        }
        
        for (i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }
        
        return sb[0].toString();
    }
}