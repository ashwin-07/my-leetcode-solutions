class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[1], b[1]));
        
        for (int i = 0; i < intervals.length - 1; i++) {
            
            if (intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
            
        }
        
        return true;
        
    }
}