class Solution {
    public int sumSubarrayMins(int[] arr) {
        long result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        long M = 1000000007;
        stack.push(-1);
        
        for (int currIdx = 0; currIdx < arr.length+1; currIdx++){
            int currVal = (currIdx<arr.length)? arr[currIdx] : 0;
            
            while(stack.peek() !=-1 && currVal < arr[stack.peek()]){
                int index = stack.pop();
                int minToLeftIdx = stack.peek();
                int left = index - minToLeftIdx;
                int right = currIdx - index;
                long add = (long)(left * right * (long)arr[index]) % M;
                result += add ;
                result %= M;
            }
            
            stack.push(currIdx);
            
        }
        
        return (int)result;
        
    }
}