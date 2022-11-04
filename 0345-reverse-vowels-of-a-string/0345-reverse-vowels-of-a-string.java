class Solution {
    
    public String reverseVowels(String s) {

        Set vowelsSet = Set.of('a', 'e', 'i', 'o', 'u',
                                'A', 'E', 'I', 'O', 'U');
        
        char[] chars = s.toCharArray();
        
        int start = 0;
        int end = s.length() - 1;
        
        while (start < end) {
            if (!vowelsSet.contains(chars[start])) {
                start++;
                continue;
            }
            
            if (!vowelsSet.contains(chars[end])) {
                end--;
                continue;
            }
            
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            
            start++;
            end--;
        }
        
        return new String(chars);

    }
}
    