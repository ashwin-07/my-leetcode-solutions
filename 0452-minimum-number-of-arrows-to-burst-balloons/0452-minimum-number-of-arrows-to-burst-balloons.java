class Solution {
    public int findMinArrowShots(int[][] points) {
        
        int prevIdx = 0;
        int noOfArrowsRqd = 1;
        
        Arrays.sort(points, (a,b) -> Integer.compare(a[1],b[1]));
        
        for (int currIdx = 1; currIdx < points.length; currIdx++) {
            if (points[currIdx][0] > points[prevIdx][1]) {
                noOfArrowsRqd++;
                prevIdx = currIdx;
            }  
        }
        
        return noOfArrowsRqd;
    }
}



                   
                   
                  