class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
        
        if (nums.length < 3){
            return false;
        }
        
        
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] <= a) {
                a = nums[i];
            }
            else if (nums[i] <= b && nums[i] > a) {
                b = nums[i];
            }
            else if (nums[i] <= c && nums[i] > b) {
                c = nums[i];
                return true;
            }
        }
        return false;
        
    }
}