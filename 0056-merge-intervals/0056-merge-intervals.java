class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (int []a, int []b) -> {
            return Integer.compare(a[0], b[0]);
        });
        
        ArrayList<int[]> list = new ArrayList<>();
        
        int[] newInterval = new int[2]; 
        newInterval[0] = intervals[0][0];
        newInterval[1] = intervals[0][1];
        
        list.add(newInterval);
        
        for (int  i = 1; i < intervals.length; i++) {
            
            if (newInterval[1] >= intervals[i][0]) {
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
            else {
                newInterval = intervals[i];
                list.add(newInterval);
            }
            
        }
        
        
        return list.toArray(new int[list.size()][2]);
        
    }
}