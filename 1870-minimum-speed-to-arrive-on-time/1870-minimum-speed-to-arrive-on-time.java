class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int minReqSpeed = -1;
        int left = 1, right = (int)10e7;

        while (left <= right) {
            int mid = (left + right) / 2;

            double timeReqForSpeed = getTimeRequiredForSpeed(dist, mid);
            
            if (timeReqForSpeed <= hour) {
                minReqSpeed = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minReqSpeed;
    }
    
    
    double getTimeRequiredForSpeed(int[] dist, int speed) {
        double totalTime = 0.0;
        for (int i = 0 ; i < dist.length; i++) {
            double currTimeReq = ((double) dist[i]) / ((double) speed);
            totalTime += (i == dist.length - 1 ? currTimeReq
                          : Math.ceil(currTimeReq));
        }
        return totalTime;
    }
}