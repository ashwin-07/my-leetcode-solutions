class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack();
        
        
        int curDigit = 0;
        StringBuilder currStr = new StringBuilder();
        
        for (char ch:s.toCharArray()) {
            
            if (Character.isDigit(ch)) {
                curDigit = curDigit * 10 + (ch - '0');
            }
            else if (ch == '[') {
                
                intStack.push(curDigit);
                strStack.push(currStr);
                curDigit = 0;
                currStr = new StringBuilder();
                
            }
            else if (ch == ']') {
                StringBuilder temp = currStr;
                currStr = strStack.pop();
                int reps = intStack.pop();
                for (int i = 0; i < reps; i++) {
                    currStr.append(temp);
                }
            }
            else {
                currStr.append(ch);
            }
            
        }
        
        return currStr.toString();
        
        
    }
}