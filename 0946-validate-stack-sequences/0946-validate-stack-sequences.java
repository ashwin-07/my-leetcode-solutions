class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {  
        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        
        for (int i:pushed) {
            stack.push(i);
            
            while (!stack.isEmpty() && popped[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }
        
        return stack.isEmpty();
        
    }
}