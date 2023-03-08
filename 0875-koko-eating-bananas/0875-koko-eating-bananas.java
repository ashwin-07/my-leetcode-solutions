class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int min = 1;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for (int p:piles) {
            max = Math.max(max, p);
            sum+=p;
        }

        while (min < max) {            
            int mid = min + (max-min)/2;
            int days = 0;
            
            for (int p: piles) {
                days+=(int)Math.ceil((double)p / mid);
            } 
            if (days > h) {
                min = mid + 1;
            }
            else {
                max = mid;
            }
            
        }
        return min;    
    }
}