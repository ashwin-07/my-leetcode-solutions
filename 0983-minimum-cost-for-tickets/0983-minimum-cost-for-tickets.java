class Solution {
    
    public int mincostTickets(int[] days, int[] costs) {
        
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay+1];
        boolean[] isTravelDay = new boolean[lastDay+1];
        
        for (int day: days) {
            isTravelDay[day] = true;
        }
        
        for (int i = 1; i <= lastDay; i++) {  
            if (!isTravelDay[i]) {
                dp[i] = dp[i-1];
            }
            else {        
                int oneDayTicketCost = dp[i-1] + costs[0];
                int sevenDayTicketCost = dp[Math.max(0, i-7)] + costs[1];
                int thirtyDayTicketCost = dp[Math.max(0, i - 30)] + costs[2];
    
                dp[i] = Math.min(oneDayTicketCost, Math.min(sevenDayTicketCost, thirtyDayTicketCost));
            }
        }
        return dp[lastDay];
    }  
}






    
       