class Solution {
    

    public List<String> letterCombinations(String digits) {
        
            
    Map<Character, String> wordMaps = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
         put('4', "ghi");
         put('5', "jkl");
         put('6', "mno");
         put('7', "pqrs");
         put('8', "tuv");
         put('9', "wxyz");
    }};
        
        List<String> result = new ArrayList<>();
        
        if (digits.length() == 0) {
            return result;
        }
        
        result.add("");
        
        for (char ch: digits.toCharArray()) {
            result = buildCombination(wordMaps.get(ch), result);
        }
        return result;
    }
    
    public List<String> buildCombination(String combination, List<String> existingRes){
        
        List<String> result = new ArrayList<>();
        
        for (char ch: combination.toCharArray()) {
            for (String s: existingRes) {
                result.add(s+ch);
            }
        }
        
        return result;
        
    }
}