class Solution {
    
    public int maxSatisfaction(int[] satisfaction) {
        
        int maxSatisfaction = 0;
        int sumSoFar = 0;

        Arrays.sort(satisfaction);
        
        for (int i = satisfaction.length - 1; i >= 0; i--) {
           sumSoFar+=satisfaction[i];
           if (sumSoFar < 0) {
               break;
           }
           maxSatisfaction+=sumSoFar; 
        }
        
        return maxSatisfaction;      
    }
}
    
