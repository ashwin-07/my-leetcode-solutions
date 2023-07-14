class Solution {
    public int longestSubsequence(int[] nums, int difference) {
        
        Map<Integer, Integer> numAndSeqLen = new HashMap<>();
        int maxSeqLen = 1;
        
        for (int num: nums) {
            int seqLenForDiff = numAndSeqLen.getOrDefault(num - difference, 0);
            numAndSeqLen.put(num, seqLenForDiff+1);
            maxSeqLen = Math.max(maxSeqLen, seqLenForDiff+1);
        }
        return maxSeqLen;
    }
}