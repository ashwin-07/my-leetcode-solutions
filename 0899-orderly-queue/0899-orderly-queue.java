class Solution {
    public String orderlyQueue(String s, int k) {
        
        String result;
        if (k == 1) { //rotation
            result = s;
            for (int i = 0; i < s.length(); i++) {
                String temp = s.substring(i) + s.substring(0, i);
                if (temp.compareTo(result) < 0) {
                   result = temp;
                }
            }
        }
        else { //min possible string
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            result = new String(chars);
        }
        return result;
    }
}

