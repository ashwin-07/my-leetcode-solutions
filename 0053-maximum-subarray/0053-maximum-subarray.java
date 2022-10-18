class Solution {
    public int maxSubArray(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int curr = 0;
        for (int i : nums) {
            max = Math.max(max, curr+=i);
            if (curr < 0) {
                curr = 0;
            }
        }
        return max;
    }
}