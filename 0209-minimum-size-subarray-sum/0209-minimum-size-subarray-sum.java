class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int r = 0, l = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        boolean sumFound = false;
        
        for (r = 0; r < nums.length; r++) {
            sum+=nums[r]; 
            while(sum >= target && l <= r) {
                if (sum >= target) {
                    if (!sumFound) {
                        sumFound = true;
                    }
                    minLen = Math.min(minLen, (r - l)+1);
                }
                sum-=nums[l++];
            }   
        }
        
        return sumFound? minLen:0;
    }
}