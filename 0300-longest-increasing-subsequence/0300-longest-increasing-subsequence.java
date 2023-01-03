class Solution {
    public int lengthOfLIS(int[] nums) {
        //nlogn        
        int[] tails = new int[nums.length];
        
        int maxLen = 0;
        
        for (int num:nums) {
            int idx = Arrays.binarySearch(tails, 0, maxLen, num);
            if (idx < 0) {idx= -(idx + 1);}
            tails[idx] = num;
            if (idx == maxLen) {maxLen++;}
        }
        return maxLen;
    }
     
 //dp n^2       
 /*       
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            
            int currMax = 0;
            
            for (int j = 0; j < i; j++) {
                
                if (nums[i] > nums[j]) {
                    currMax = Math.max(dp[j], currMax); 
                }                
            }
            dp[i] = currMax + 1;
            max = Math.max(max, dp[i]);            
        }                
        return max;                 
    }
    */
}