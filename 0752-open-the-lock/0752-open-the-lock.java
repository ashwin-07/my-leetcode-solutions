class Solution {
    public int openLock(String[] deadends, String target) {
        
        
        HashSet<String> deadendSet = new HashSet<String>(Arrays.asList(deadends));
        
        Set<String> end = new HashSet<String>();
        Set<String> begin = new HashSet<String>();
        
        begin.add("0000");
        end.add(target);
        
        int level = 0;
        Set<String> temp;
        while (!end.isEmpty() && !begin.isEmpty()) {

//             if (begin.size() > end.size()) { 
//                 temp = begin;
//                 begin = end;
//                 end = temp; 
                
//             }
            
            temp = new HashSet<String>();
            
            for (String curr:begin) {
                
                if (end.contains(curr)) {
                    return level;
                }
                
                if (deadendSet.contains(curr)) {
                    continue;
                }
                
                deadendSet.add(curr);
                
                StringBuilder sb = new StringBuilder(curr);
                for (int i = 0; i < 4; i++) {
                    char ch = sb.charAt(i);
                    String nextStr = sb.substring(0, i) + (ch == '9' ? 0 : ch - '0' + 1) + sb.substring(i + 1); // 0000  -> 1000
                    String prevStr = sb.substring(0, i) + (ch == '0' ? 9 : ch - '0' - 1) + sb.substring(i + 1); // 0000  -> 9999
                    
                    if (!deadendSet.contains(nextStr)) {
                        temp.add(nextStr);
                    }
                    if (!deadendSet.contains(prevStr)) {
                         temp.add(prevStr);
                    }
                    
                } 
                // size--;
            }
            
            level++;
            begin = end;
            end = temp;
            // end = temp;
            
            
        }
        
        return -1;
        
    }
}