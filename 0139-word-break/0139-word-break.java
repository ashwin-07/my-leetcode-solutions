class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean[] isWordAtFormedAtIdx = new boolean[s.length()+1];
        Set<String> dict = new HashSet<>(wordDict);
        isWordAtFormedAtIdx[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {                
                if (isWordAtFormedAtIdx[j] && dict.contains(s.substring(j,i))) {
                    isWordAtFormedAtIdx[i] = true;
                    break;
                }
            }
        }

       return  isWordAtFormedAtIdx[s.length()];
        
    }
}