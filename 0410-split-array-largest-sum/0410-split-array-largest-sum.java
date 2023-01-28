class Solution {
    public int splitArray(int[] nums, int m) {
        
        int minPossible = 0, maxPossible = 0;
        
        for (int num:nums) {
            minPossible = Math.max(num, minPossible);
            maxPossible+=num; 
        }
        
        while (minPossible < maxPossible) {
            int mid = (minPossible) + (maxPossible - minPossible) / 2;
            if (canSplit(nums, mid, m)) {
                maxPossible = mid;
            }
            else {
                minPossible = mid+1;
            }
            
        }
       return minPossible; 
    }
    
    boolean canSplit(int[] nums, int target, int m) {
        int currSum = 0, currSplits = 1;
        for (int num:nums) {
            currSum+=num;
            if (currSum > target) {
                currSum = num;
                currSplits++;
                
                if (currSplits > m) {
                    return false;
                }
            }
        }
        return true; 
    }
}