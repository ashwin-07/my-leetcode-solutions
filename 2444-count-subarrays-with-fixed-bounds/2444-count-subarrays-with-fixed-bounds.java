class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        int currBoundStartIdx = -1;
        int minNumIdx = -1;
        int maxNumIdx = -1;
        
        long numOfSubArrs = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] > maxK || nums[i] < minK) {
                currBoundStartIdx = i;
            }
            
            if (nums[i] == minK) {
                minNumIdx = i;
            }
            if (nums[i] == maxK) {
                maxNumIdx = i;
            }
            
            numOfSubArrs+=Math.max(0, Math.min(maxNumIdx, minNumIdx) - currBoundStartIdx);
            
        }
        
        return numOfSubArrs;
        
    }
}