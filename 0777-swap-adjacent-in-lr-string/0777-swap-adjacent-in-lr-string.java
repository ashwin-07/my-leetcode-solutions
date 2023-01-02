class Solution {
    public boolean canTransform(String start, String end) {
        
        if (!start.replace("X","").equals(end.replace("X",""))) {
            return false;
        }
        
        int ptr1 = 0, ptr2 = 0;
        
        while (ptr1 < start.length() && ptr2 < end.length()) {
            
            while (ptr1 < start.length() && start.charAt(ptr1) == 'X') {
                ptr1++;
            }
            
            while (ptr2 < end.length() && end.charAt(ptr2) == 'X') {
                ptr2++;
            }
            
            if (ptr1 == start.length() && ptr2 == end.length()) {
                return true;
            }
            if (ptr1 == start.length() || ptr2 == end.length()) {
                return false;
            }
            
            if (start.charAt(ptr1) != end.charAt(ptr2)) {
                return false;
            }
            
            if (start.charAt(ptr1) == 'L' && ptr2 > ptr1) {
                return false;
            }
            
            if (start.charAt(ptr1) == 'R' && ptr2 < ptr1) {
                return false;
            }

            ptr1++;
            ptr2++;
        }
        
        return true;
        
    }
}

