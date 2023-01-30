class Solution {
    
    public int tribonacci(int n) {
        
        if (n < 2) {
            return n;
        } 
        
        int prev1 = 1;
        int prev2 = 1;
        int prev3 = 0;
        
        int itr = n - 2;
        int curr = 1;
        while (itr-- > 0) {
            curr = prev1+prev2+prev3;
            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr; 
        }
        
        return curr;
        
    }
}