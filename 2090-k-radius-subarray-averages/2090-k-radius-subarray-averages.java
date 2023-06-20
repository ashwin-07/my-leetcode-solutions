class Solution {
    //Dialy challenge 20th June 2023
    public int[] getAverages(int[] nums, int k) {
        
        long sumSoFar = 0;
        
        int[] result = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            sumSoFar+=nums[i];
            if (i < k) {
                result[i] = -1;
            }
            else if (i >= 2*k){
                result[i - k] = (int) (sumSoFar / (2*k+1));
                sumSoFar-=nums[i - 2*k];
            }
            
            if (i >= nums.length-k) {
                result[i] = -1;
            }   
        }
        
        return result;
        
    }
}