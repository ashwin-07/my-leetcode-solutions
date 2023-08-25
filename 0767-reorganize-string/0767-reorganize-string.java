class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        int max = -1;
        char maxChar = s.charAt(0);
        
        for (char ch:s.toCharArray()) {
            count[ch - 'a']++;
            if (count[ch - 'a'] > max) {
                max = count[ch - 'a'];
                maxChar = ch;
            }    
        }
        
        if (max > ((s.length()+1) / 2)) {
            return "";
        }
        
        char[] res = new char[s.length()];
        int idx = 0;
        
        while(count[maxChar - 'a'] > 0) {
            
            res[idx] = maxChar;
            idx+=2;
            count[maxChar - 'a']--;
        }
        
        for (int i = 0; i < count.length; i++){           
            while (count[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char)(i + 'a');
                idx+=2;
                count[i]--;
            }
            
        }
        return String.valueOf(res);
    }
}