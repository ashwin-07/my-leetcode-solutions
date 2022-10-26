class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> indexForRemainderMap = new HashMap<>();
        
        indexForRemainderMap.put(0, 0);
        
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if (!indexForRemainderMap.containsKey(sum % k)) {
                indexForRemainderMap.put(sum % k, i + 1);
            }
            else if (i - indexForRemainderMap.get((sum % k)) > 0) {
                return true;
            }
        }
        
        return false;
        
    }
}