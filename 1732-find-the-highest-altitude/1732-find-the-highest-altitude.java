class Solution {
    //Solved as part of Daily challenge 19th June 2023
    public int largestAltitude(int[] gains) {
        int currAltitude = 0;
        int maxAltitude = currAltitude;

        for (int gain : gains) {
          currAltitude+=gain;
          maxAltitude=Math.max(maxAltitude, currAltitude);
        }

        return maxAltitude;        
    }
}