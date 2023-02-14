class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder result = new StringBuilder();
        int m = a.length() - 1, n = b.length() -1;
        int carry = 0;
        
        while (m >= 0 || n >= 0) {
            
            int sum = carry;
            if (m >= 0) { 
                sum += a.charAt(m) - '0';
                m--;
            }
            if (n >= 0){ 
                sum += b.charAt(n) - '0';
                n--;
            }
            result.append(sum % 2);
            carry = sum / 2;
        }
        
        if (carry > 0) {
            result.append(carry);
        }
        
        return result.reverse().toString();
    }
}