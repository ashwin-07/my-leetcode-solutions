class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] prodArr = new int[nums.length];
        int prodSoFar = 1;
        
        for (int i = 0; i < nums.length; i++) {
            prodSoFar*=nums[i];
            prodArr[i]=prodSoFar;
        }
        
        prodSoFar = 1;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            int val = (i-1) < 0 ? 1 : prodArr[i-1];
            prodArr[i] = prodSoFar*val;
            prodSoFar*=nums[i];

        }
        
        return prodArr;
        
    }
}