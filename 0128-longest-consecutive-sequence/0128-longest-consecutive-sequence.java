class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<Integer>();
        
        for (int num: nums) {
            set.add(num);
        }
        
        int max = 0;
        
        for (int num:nums) {
            
            if (!set.contains(num-1)){
                
                int currStreak = 1;
                int currNum = num+1;
                
                while(set.contains(currNum)) {
                    currNum++;
                    currStreak++;
                }
                
                max = Math.max(max, currStreak);
                
            }
            
        }
        
        return max;
        
    }
}