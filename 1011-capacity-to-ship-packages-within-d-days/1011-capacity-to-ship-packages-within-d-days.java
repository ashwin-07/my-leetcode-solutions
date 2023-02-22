class Solution {
    public int shipWithinDays(int[] weights, int D) {
        
        
        int sum = 0, max = Integer.MIN_VALUE;
        
        for (int w:weights) {
            sum+=w;
            max=Math.max(max, w);
        }
        
        while (max < sum) {
            
            int mid = (max+sum) / 2;
            int reqDays = 1, cap = 0;
            for (int w:weights) {
                if (cap+w > mid) {
                    reqDays++;
                    cap = 0;
                }
                cap+=w;
            }
            
            if (reqDays > D) {
                max = mid+1;
            }
            else {
                sum = mid;
            }
            
        }
        
        return max;
        
    }
}