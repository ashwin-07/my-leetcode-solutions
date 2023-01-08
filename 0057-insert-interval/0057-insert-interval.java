class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
       int i = 0;
        
        
       List<int[]> intervalsList = new ArrayList<>();
        
       while (i < intervals.length && newInterval[0] > intervals[i][1]) {
           intervalsList.add(intervals[i]);
           i++;
       } 

        
        while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
           newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
       }

        
        intervalsList.add(newInterval);
       
        while (i < intervals.length) {
            intervalsList.add(intervals[i]);
            i++;
        }
        
        
        return intervalsList.toArray(new int[0][]);
        
        
    }
}