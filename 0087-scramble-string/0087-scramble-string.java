class Solution {

    Map<String,Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        return isStringsScrambled(s1, s2);
    }

    public boolean isStringsScrambled(String s1, String s2) {
        if(s1.equals(s2)) {
            return true;
        }

        int[] s1CharCount = new int[26];
        int[] s2CharCount = new int[26];
        boolean isScrambled = false;

        for(int i = 0; i < s1.length(); i++) {
            s1CharCount[s1.charAt(i) - 'a']++;
            s2CharCount[s2.charAt(i) - 'a']++;
        }

        String key = s1 + "-" + s2;

        if(memo.containsKey(key))
            return memo.get(key);

        for(int i = 0; i < 26; i++) {
            if (s1CharCount[i] != s2CharCount[i]) {
                memo.put(key, false);
                return memo.get(key);
            }
        }

        for(int i = 1; i < s1.length(); i++) {
            if( isStringsScrambled(s1.substring(i), s2.substring(i)) &&
                    isStringsScrambled(s1.substring(0, i), s2.substring(0, i)) ){
                isScrambled = true;
                break;
            }

            if( isStringsScrambled(s1.substring(i), s2.substring(0, s1.length() - i)) &&
                    isStringsScrambled(s1.substring(0, i), s2.substring(s1.length() - i))){
                isScrambled = true;
                break;
            }
        }

        memo.put(key, isScrambled);
        return memo.get(key);
    }
    
}