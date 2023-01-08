public class Codec {

    private final String TOKEN = "/";
    
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str:strs) {
            sb.append(str.length()).append(TOKEN).append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0;
        List<String> orgList = new ArrayList<>();
        while (i < s.length()) {
            int indexOfToken = s.indexOf(TOKEN, i);
            int strLen = Integer.parseInt(s.substring(i, indexOfToken));
            String orgStr = s.substring(indexOfToken+1, indexOfToken+1+strLen);
            orgList.add(orgStr);
            i=indexOfToken+1+strLen;
        }
        return orgList;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));