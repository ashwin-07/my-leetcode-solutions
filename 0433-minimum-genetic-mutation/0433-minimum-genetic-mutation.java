class Solution {
    public int minMutation(String start, String end, String[] bank) {
        
        
        Queue<String> queue = new LinkedList<>();
        
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        
        char[] mutationChoices = new char[]{'A', 'C', 'G','T'};
        
        int mutationCount = 0;
        
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            
            while (size-- > 0) {
                String currMutation = queue.poll();
                if (currMutation.equals(end)) {
                    return mutationCount;
                }
                
                for (int i = 0; i < currMutation.length(); i++) {
                    
                    char orgChar = currMutation.charAt(i);
                    char[] currMutChars = currMutation.toCharArray();
                    
                   for(char mutationChoice:mutationChoices) {
                        currMutChars[i] = mutationChoice; 
                        String nextMutation = String.valueOf(currMutChars);
                       
                        if (!bankSet.contains(nextMutation)) {
                            continue;
                        }
                        else {
                         bankSet.remove(nextMutation);
                         queue.add(nextMutation);
                        }
                       
                   }
                   currMutChars[i] = orgChar;
                    
                }
                
            }
            mutationCount++;
            
        }
        
        
        
        
        return -1;
        
        
    }
}