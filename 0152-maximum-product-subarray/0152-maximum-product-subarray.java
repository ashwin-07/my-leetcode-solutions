class Solution {
    public int maxProduct(int[] nums) {
        
        int max = Integer.MIN_VALUE, n = nums.length;
        int prodFromL = 0, prodFromR = 0;
        
        for (int i = 0; i < n; i++) {
            prodFromL = (prodFromL == 0 ? 1 : prodFromL) * nums[i];
            prodFromR = (prodFromR == 0 ? 1: prodFromR) * nums[n - 1 - i];
            max = Math.max(max, Math.max(prodFromL, prodFromR));
        }
        
        return max;
    }
}