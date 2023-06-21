class Solution {
    public int longestSubarray(int[] nums) {
        int startIdx = 0, numOfReplacements = 1;
        int maxLen = 0;
        
        for (int currIdx = 0; currIdx < nums.length; currIdx++) {
            if (nums[currIdx] == 0) {
                numOfReplacements--;
            }
            while (numOfReplacements < 0) {
                if (nums[startIdx] == 0) {
                    numOfReplacements++;
                }
                startIdx++;
            }
            maxLen = Math.max(maxLen, currIdx - startIdx);
        }
        return maxLen;
    }
}