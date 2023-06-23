import java.util.*;

class Solution {
    public int hIndex(int[] citations) {
       
        int citationSum = 0;;
        int len = citations.length;
        
        int[] citationsCount = new int[len+1];
        for (int citation:citations) {
            if (citation > len) {
                citationsCount[len]+=1;
            } else {
                citationsCount[citation]+=1;
            }
        }
        
        while (len > 0) {
            citationSum+=citationsCount[len];
            if (citationSum >= len) {
                return len;
            }
            len--;
        }
        return 0;
    }
}
