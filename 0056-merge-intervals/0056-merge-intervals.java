class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (int [] a, int []b) -> {
            return a[0] - b[0];
        });
        
        List<int[]> list = new ArrayList<>();
        int[] newInterval = intervals[0];
        list.add(newInterval);
        
        for(int[] interval:intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
            else {
                newInterval = interval;
                list.add(newInterval);
            }
        }
        
        
        
        return list.toArray(new int[list.size()][2]);
        
    }
}