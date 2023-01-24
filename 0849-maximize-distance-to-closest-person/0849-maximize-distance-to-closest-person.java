class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int last = -1, result = 0;
        int n = seats.length;
        
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                result = last < 0? i : Math.max(result, (i - last)/2);
                last = i;
            }
        }
        
        result = Math.max(result, n - last - 1);
        return result;
    }
}