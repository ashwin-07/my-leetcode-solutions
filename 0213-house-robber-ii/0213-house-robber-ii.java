class Solution {
    public int rob(int[] nums) {
        
        if (nums.length == 1){
            return nums[0];
        }
        return Math.max(find(nums,0), find(nums,1));

        
    }
    
    public int find(int[] nums, int start) {
        int curr = 0, temp = 0, prev = 0;
        
        for (int i = start; i < nums.length - (1 - start); i++) {
            temp = curr;
            curr = Math.max(nums[i]+prev, curr);
            prev = temp;
        }
        
        return curr;
    }
}