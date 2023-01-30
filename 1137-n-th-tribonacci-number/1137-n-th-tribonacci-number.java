class Solution {
    
    public int tribonacci(int n) {
        
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }
        
        int prev1 = 1;
        int prev2 = 1;
        int prev3 = 0;
        
        int itr = n - 2;
        int curr = 0;
        while (itr-- > 0) {
            
            curr = prev1+prev2+prev3;
            int temp = prev1;
            int temp2 = prev2;
            prev1 = curr;
            prev2 = temp;
            prev3 = temp2;
            
        }
        
        return curr;
        
    }
}