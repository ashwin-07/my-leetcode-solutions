/*
   ID: 3
   Difficulty: Medium
   Topic: HashTable, Two pointers

   Description Given a string s, find the length of the longest substring without repeating characters.

*/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        
//attempt 1      
        
//         HashMap<Character, Integer> occurenceMap = new HashMap<Character, Integer>();
        
//         int i = 0;
//         int maxLen = 0;
        
//         while (i < s.length()) {
            
//             if (occurenceMap.containsKey(s.charAt(i))) {
//                 i = occurenceMap.get(s.charAt(i)) + 1;
//                 occurenceMap = new HashMap<Character, Integer>();    
//             }
//             else {
//                 occurenceMap.put(s.charAt(i), i);
//                 if (occurenceMap.size() > maxLen) {
//                     maxLen = occurenceMap.size();
//                 }
//                 i++;
//             }
            
//         }
//        return maxLen; 
        

//attempt 2
        
        
//         HashMap<Character, Integer> occurenceMap = new HashMap<Character, Integer>();
//         int maxLen = 0;
//         int start = 0;
        
//         for (int i = 0; i < s.length(); i++) {
            
//             if (occurenceMap.containsKey(s.charAt(i)) && occurenceMap.get(s.charAt(i)) >= start) {
//                 int index = occurenceMap.get(s.charAt(i));
//                 if ( i - start > maxLen) {
//                     maxLen = i - start;
//                 }
//                     start = index + 1;
//                     occurenceMap.put(s.charAt(i), i);
//             }
//             else{
//                 if ( i ==  s.length()-1 && (i+1) - start > maxLen){
//                     maxLen =  (i+1) - start;
//                 }
//                 occurenceMap.put(s.charAt(i), i);
//             }
            
//         }
        
        
        
//attempt 3, more optimized
        
        HashMap<Character, Integer> occurenceMap = new HashMap<Character, Integer>();
        int maxLen = 0;
        
        for (int i = 0, j = 0; i < s.length(); i++) {
            
            if (occurenceMap.containsKey(s.charAt(i))) {
                j = Math.max(j, occurenceMap.get(s.charAt(i)));
            }
            
            maxLen = Math.max(maxLen, i - j + 1);
            occurenceMap.put(s.charAt(i), i + 1);
            
        }
 
        return maxLen;
        
        
    }
}