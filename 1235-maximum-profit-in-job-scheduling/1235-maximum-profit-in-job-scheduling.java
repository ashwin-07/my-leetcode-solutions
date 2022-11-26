class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        
        Arrays.sort(jobs, (a,b) -> a[1] - b[1]);
        
        
        int[] maxProfit = new int[n];
        maxProfit[0] = jobs[0][2];
        for (int i = 1; i < n; i++) {
            
            int currProfit = jobs[i][2];
            int prevProfit = findPrevProfitIdx(i,jobs);
            if (prevProfit != -1) {
                currProfit+=maxProfit[prevProfit];
            }
            
            maxProfit[i] = Math.max(maxProfit[i-1], currProfit);
        }
        
        return maxProfit[n-1];
        
    }
    
    int findPrevProfitIdx(int endIdx, int[][] jobs) {
        int start = 0;
        int end = endIdx-1;
        while (start <= end) {
            
            int mid = (start+end)/2;
            if (jobs[mid][1] <= jobs[endIdx][0]) {
                if (jobs[mid+1][1] <= jobs[endIdx][0]) {
                    start = mid+1;
                }
                else {
                    return mid;
                }
            }
            else {
                end = mid-1;
            }
            
        }
        return -1;
    }
}