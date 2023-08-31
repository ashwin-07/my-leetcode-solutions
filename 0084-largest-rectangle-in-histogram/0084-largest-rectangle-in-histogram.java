class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int largest = 0;
        
        for (int i = 0; i <= n;) {
            
            int h = i == n ? 0 : heights[i];
            
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            }
            else {
                int top = heights[stack.pop()];
                int left = stack.isEmpty()? 0 : stack.peek()+1;
                int right = i;
                largest = Math.max(largest, top * ((right - left)));
            }
            
        }
        
        return largest;  
    }
}