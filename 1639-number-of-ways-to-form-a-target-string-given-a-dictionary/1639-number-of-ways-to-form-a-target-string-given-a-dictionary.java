class Solution {
    
    int MOD = 1000000007;
    
    public int numWays(String[] words, String target) {

        int targetLen = target.length(), wordsLen = words[0].length();
        
        int charWordCount[][] = new int[26][wordsLen];
        
        for (int j = 0; j < wordsLen; j++) {
            for (String word : words) {
                charWordCount[word.charAt(j) - 'a'][j]++;
            }
        }
        
        long dp[][] = new long[targetLen + 1][wordsLen + 1];
        dp[0][0] = 1;
        
        for (int i = 0; i <= targetLen; i++) {
            for (int j = 0; j < wordsLen; j++) {
                if (i < targetLen) {
                    dp[i + 1][j + 1] = (dp[i + 1][j + 1] + (charWordCount[target.charAt(i) - 'a'][j] * dp[i][j])) % MOD;
                }
                dp[i][j + 1] = (dp[i][j + 1] + dp[i][j]) % MOD;
            }
        }
        
        return (int)dp[targetLen][wordsLen];
    }
}