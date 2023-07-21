class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] len = new int[n];
        int[] count = new int[n];
        
        
        Arrays.fill(len, 1);
        Arrays.fill(count, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                
                if (nums[i] > nums[j]) {
                    
                    if (len[j]+1 > len[i]) {
                        len[i] = 1+len[j];
                        count[i] = count[j];
                    }
                    else if (len[j]+1 == len[i]) {
                        count[i]+=count[j];
                    }
                    
                }
                
            }
        }
        
        int max = 0;
        for (int i:len) {
            max = Math.max(max, i);
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (len[i] == max) {
                ans+=count[i];
            }
        }
        
        return ans;
    }
}