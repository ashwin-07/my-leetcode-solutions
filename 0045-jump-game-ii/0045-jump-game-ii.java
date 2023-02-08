class Solution {
    public int jump(int[] nums) {
        
        int farthestPossible = 0, currRange = 0;
        
        int jumps = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            
            farthestPossible = Math.max(farthestPossible, i + nums[i]);
            
            if (i == currRange) {
                jumps++;
                currRange = farthestPossible;
            }
            
        }
        
        return jumps;
        
    }
}