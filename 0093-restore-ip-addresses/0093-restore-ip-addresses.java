class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new LinkedList<>();
        backtrack(s, list, new StringBuilder(), 0, 0);
        return list;
    }
    
    void backtrack(String s, List<String> list, StringBuilder sb, int index, int level){
    
        if (index > s.length() || level > 4) {
            return;
        }
        else if (index == s.length() && level == 4) {
            list.add(sb.toString());
            return;
        }
        for (int i = 1;i <= 3;i++) {
            
            if(index+i > s.length()) {
                break;
            }
            int num = Integer.valueOf(s.substring(index,index+i));

            if(i == 1 || i==2 && num >=10 && num <=99 || i == 3 && num >= 100 && num <= 255){
                sb.append(num);
                if(level < 3) sb.append(".");
                backtrack(s,list,sb,index+i,level+1);
                if(level < 3) sb.deleteCharAt(sb.length()-1);
                sb.delete(sb.length()-i,sb.length());
            }
        }
    }   
}