class Solution {
    public int rob(int[] nums) {
        
        //T: O(n)   S: O(n)
//         int[] dp = new int[nums.length+1];
//         dp[0] = 0;
//         dp[1] = nums[0];
        
//         for (int i = 1; i < nums.length; i++) {
//             dp[i+1] = Math.max(dp[i-1]+nums[i], dp[i]);
//         }
        
//         return dp[nums.length];
        
        //T: O(n)   S: O(1)
        
        int prev1 = 0;
        int prev2 = 0;
        
        for (int num:nums) {
            
            int temp = prev1;
            prev1 = Math.max(prev2+num, prev1);
            prev2 = temp;
            
        }
        
        return prev1;
          
        
    }
}