class Solution {
    public int maxOperations(int[] nums, int k) {
        
        HashMap<Integer, Integer> numberFrequencyMap = new HashMap<>();
        int kSumPairsCount = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            int requiredNum = k - nums[i];
            
            if (numberFrequencyMap.containsKey(requiredNum)) {   
                kSumPairsCount++;
                int requiredNumFrequency = numberFrequencyMap.get(requiredNum);
                if (requiredNumFrequency == 1) {
                    numberFrequencyMap.remove(requiredNum);
                }
                else {
                    numberFrequencyMap.put(requiredNum, requiredNumFrequency - 1);
                } 
                
            } else {
                numberFrequencyMap.put(nums[i], numberFrequencyMap.getOrDefault(nums[i], 0)+1);
            }
            
        }
        
        return kSumPairsCount;
        
    }
}