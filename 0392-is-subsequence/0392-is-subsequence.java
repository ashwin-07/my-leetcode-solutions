class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int sptr = 0, tptr = 0;
        while (tptr < t.length()) {
            if (s.charAt(sptr) == t.charAt(tptr)) {
                sptr++;
                if (sptr == s.length()) {
                    return true;
                }
            }
            tptr++;
        }
        return false;
    }
}