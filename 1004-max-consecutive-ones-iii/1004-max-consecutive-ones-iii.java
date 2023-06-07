class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int leftIdx = 0, rightIdx = 0, maxConseq = 0, zerosCount = 0;
    
        for (rightIdx = 0; rightIdx < nums.length; rightIdx++) {

            if (nums[rightIdx] == 0) {
                zerosCount++;
            }
        
            if (zerosCount > k) {
                if (nums[leftIdx] == 0) {
                    zerosCount--;
                }
                leftIdx++;
            }
            else if (zerosCount <= k) {
                maxConseq = Math.max(maxConseq, rightIdx - leftIdx +1 );
            }
        }
        return maxConseq; 
    }
}