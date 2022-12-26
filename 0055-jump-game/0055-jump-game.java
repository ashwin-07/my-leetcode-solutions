class Solution {
    public boolean canJump(int[] nums) {
        
        if (nums.length == 1) {
            return true;
        }
        
        int fuel = nums[0];
        int i = 0;
        
        while (fuel > 0) {
            fuel--;
            i++;
            if (i == nums.length - 1)
            {
                return true;
            }
            fuel = Math.max(fuel, nums[i]);
        
                
        }
        
        return false;
        
    }
}