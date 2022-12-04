class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        
        long totalSum = 0;
        for (int i:nums)
            totalSum+=i;

        int idx = 0, n = nums.length;
        
        long minDiff = Integer.MAX_VALUE, sumSoFar = 0;
        
        for (int i = 0; i < n; i++) {          
            sumSoFar+=nums[i];
            long remainingSum = totalSum - sumSoFar;
            long diff = Math.abs((sumSoFar / (i+1)) - (i == n-1? 0 : remainingSum/(n-i-1)));
            if (diff < minDiff) {
                minDiff = diff;
                idx = i;
            }
        }
        
        return idx;
        
        
    }
}