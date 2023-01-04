class Solution {
    public boolean canJump(int[] nums) {
        
        if (nums.length == 1) {
            return true;
        }
        
        int maxRange = nums[0];
        int i = 0;
        
        while (i < nums.length - 1 
               && maxRange >= i 
               && maxRange <= nums.length - 1) {
            maxRange = Math.max(maxRange, nums[i]+i);
            i++;
        }
        
        return maxRange >= nums.length - 1;
        
    }
}