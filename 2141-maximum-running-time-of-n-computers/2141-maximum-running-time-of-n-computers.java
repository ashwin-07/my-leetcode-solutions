class Solution {
    public long maxRunTime(int n, int[] batteries) {
        
        // long totalPower = Arrays.stream(batteries)
        //                         .mapToLong(num -> Long.valueOf(num))
        //                         .sum(); 
        long totalPower = 0;
        for (int power:batteries) { //faster
            totalPower+=power;
        }
        
        long left = 1, right = totalPower / n;
        
        while (left < right) {
            long currTarget = right - (right - left) / 2;
            long requiredPowerForCurrTarget = 0;
             for (int power:batteries) {
                 requiredPowerForCurrTarget+=Math.min(power, currTarget);
             }
            if (requiredPowerForCurrTarget >= (long)(n * currTarget)) {
                left = currTarget;
            }
            else {
                right = currTarget - 1;
            }
            
        }
        
        return left;
        
    }
}