class Solution {
    public long minimumTime(int[] times, int totalTrips) {
        int maxTime = 0;
        for (int time : times) {
            maxTime = Math.max(maxTime, time);
        }
        long left = 1;
        long right = (long) maxTime * totalTrips;

        while (left < right) {
            long mid = (left + right) / 2;
            
            long actualTripsCount = 0;
            for (int time : times) { 
                actualTripsCount += mid / time;
            }
            
            if (actualTripsCount >= totalTrips) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}