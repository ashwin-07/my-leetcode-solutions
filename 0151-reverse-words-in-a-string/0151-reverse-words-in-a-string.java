class Solution {
    public String reverseWords(String s) {
        //taking a shortcut :)
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}