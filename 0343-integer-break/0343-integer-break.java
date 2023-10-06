class Solution {
    public int integerBreak(int n) {
        
        if (n == 2){
            return 1;
        }
         if (n == 3){
            return 2;
        }
        
        int threes = n / 3;
        int rem = n - (threes * 3);
        if (rem == 1) {
            rem+=3;
            threes--;
        }
        int twos = rem / 2;

        int sum = 0;
        sum+=Math.pow(3, threes);
        if (twos > 0) {
            sum*=Math.pow(2, twos);
        }

        return sum;
        
    }
}