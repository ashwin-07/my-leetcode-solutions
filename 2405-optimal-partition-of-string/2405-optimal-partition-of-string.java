class Solution {
    public int partitionString(String s) {
        Map<Character, Integer> charOccurence = new HashMap<>();
        int numOfPartitions = 1, previousBreak = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (charOccurence.containsKey(currChar) && charOccurence.get(currChar) >= previousBreak) {
               numOfPartitions++;
               previousBreak = i;
            }
            charOccurence.put(currChar, i);
        } 
        return numOfPartitions;
    }
}