class Solution {
    public String removeDuplicates(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        for (char ch:s.toCharArray()) {
            
            int length = sb.length();
            
            if (length > 0 && sb.charAt(length - 1) == ch) {
                sb.deleteCharAt(length - 1);
            }
            else {
                sb.append(ch);
            }
            
        }
        
        return sb.toString();
        
    }
}