class Solution {
    public boolean checkIfPangram(String sentence) {
        
        //we use 1 bit at respective index to mark presence of the character
        int seen = 0;
        
       //26 bits filled with 1 is our required val indicating all alphabets are present
        int requiredVal = (1 << 26) - 1;
        
        for (char ch:sentence.toCharArray()) {
            int currentBitPos = ch - 'a';
            seen|= (1 << currentBitPos);
            if (seen == requiredVal) { //return if we have seen all alphabets
                return true;
            }
        }
        
        return false;
        
    }
}