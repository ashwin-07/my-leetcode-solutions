class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
                
        int[] diff = new int[capacity.length];
        int result = 0;
        
        for (int i = 0; i < capacity.length; i++) {
            diff[i] = capacity[i] - rocks[i];
        }
        
        Arrays.sort(diff);
        
        for (int i = 0; i < diff.length && additionalRocks >= 0; i++) {
            additionalRocks-=diff[i];
            if (additionalRocks >= 0 ) {
                result++;
            }
        }
        
        return result;
    }
}
