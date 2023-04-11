class Solution {
    public String removeStars(String s) {
        
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        
        for (char ch:s.toCharArray()) {
            if (ch == '*') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}