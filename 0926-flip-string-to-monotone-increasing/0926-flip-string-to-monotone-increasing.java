class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int count = 0;
        for (char ch:s.toCharArray()) {
            if (ch == '0') {
             count++;   
            }
        }
        
        int ans = count;
        for (char ch:s.toCharArray()) {
            if (ch == '0') {
                ans = Math.min(ans, --count);
            }
            else {
                count++;
            }
        }
        
        return ans;
        
    }
}
