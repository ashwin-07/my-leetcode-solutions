class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        
        if (nums.length < 3){
            return false;
        }   
        
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] <= min1) {
                min1 = nums[i];
            }
            else if (nums[i] <= min2 && nums[i] > min1) {
                min2 = nums[i];
            }
            else {
                return true;
            }
        }
        return false;
        
    }
}