class Solution {
    public int evalRPN(String[] tokens) {
    
		Stack<Integer> stack = new Stack<Integer>();
		for (String token : tokens) {
            
            switch(token) { 
                case "+": {
                 stack.add(stack.pop()+stack.pop());
                 break;
                }
                case "/": {  
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.add(op2 / op1);
                    break;
                }
                case "*": {
                 stack.add(stack.pop()*stack.pop());
                 break;  
                }
                case "-": {   
                  int op1 = stack.pop();
                  int op2 = stack.pop();
                  stack.add(op2 - op1);
                break;
                }
                default:
                   stack.add(Integer.parseInt(token));
            }
		}	
		return stack.pop();
    }
    
    
    
    
}