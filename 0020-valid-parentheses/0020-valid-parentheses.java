class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> paranthesisStack = new Stack<>();
        
        for (char c:s.toCharArray()) {
            
            if (c == '(' || c == '{' || c == '[') {
                paranthesisStack.push(c);
            }
            
            else {
                if (paranthesisStack.isEmpty()) {
                    return false;
                }
                char expectedOpening = '(';
                if (c == '}') {
                    expectedOpening = '{';
                }
                else if (c == ']') {
                    expectedOpening = '[';
                }
                
                if (paranthesisStack.pop() != expectedOpening) {
                    return false;
                }
            }
            
        }
        
        return paranthesisStack.isEmpty();
    }
}