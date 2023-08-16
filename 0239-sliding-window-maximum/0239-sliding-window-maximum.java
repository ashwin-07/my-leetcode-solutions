class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> dq = new ArrayDeque<>();
        int[] maxArr = new int[nums.length - k + 1];
        int currIndex = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            while (!dq.isEmpty() && dq.peek() <= i - k) {
                dq.poll();
            }
            
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            
            dq.offer(i);
            
            if (i >= k - 1) {
                maxArr[currIndex++] = nums[dq.peek()];
            }            
        }
        
        return maxArr;
    }
}