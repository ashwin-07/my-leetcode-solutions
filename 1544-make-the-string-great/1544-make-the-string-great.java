class Solution {
    public String makeGood(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for (char ch:s.toCharArray()) {
            
            if (!stack.isEmpty() && Math.abs(stack.peek() - ch) == 32) {
                stack.pop();
            }
            else {
                stack.push(ch);
            }
            
        }
        
        char[] result = new char[stack.size()];
        
        int index = stack.size() - 1;
        
        while (!stack.isEmpty()) {
            result[index--] = stack.pop();
        }
        
        return new String(result);
        
    }
}