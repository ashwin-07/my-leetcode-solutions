class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        long continuousZeroCount = 0;
        long totalSubArrays = 0;
        
        for (int num:nums) {
            if (num == 0) {
                continuousZeroCount++;
            }
            else {
              continuousZeroCount = 0;  
            }
            totalSubArrays+=continuousZeroCount;
        }
        
        return totalSubArrays;
    }
}