class Solution {
    //solved as part of Daily challenge 23rd June
    public int longestArithSeqLength(int[] nums) {
        
        int maxSeqLen = 0;
        List<Map<Integer, Integer>> longestSequesForDiff = new ArrayList<>();
        
        for (int hiPtr = 0; hiPtr < nums.length; hiPtr++) {
            
            Map<Integer, Integer> idxDiffAndCount = new HashMap<>(); 
            longestSequesForDiff.add(idxDiffAndCount);
            
            for (int lPtr = 0; lPtr < hiPtr; lPtr++) {
                int diff = nums[lPtr] - nums[hiPtr];
                int seqLen = longestSequesForDiff.get(lPtr).getOrDefault(diff, 1);
                idxDiffAndCount.put(diff, seqLen+1);
                maxSeqLen = Math.max(maxSeqLen, idxDiffAndCount.get(diff));
            } 
        }
        
        return maxSeqLen;
    }
}