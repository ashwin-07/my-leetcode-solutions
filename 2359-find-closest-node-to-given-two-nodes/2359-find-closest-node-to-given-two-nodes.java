class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        HashMap<Integer, Integer> visited1 = new HashMap<>();
        for (int i=node1, d=0; i>=0 && !visited1.containsKey(i);) {
            visited1.put(i, d++);
            i=edges[i];
        }

        HashSet<Integer> visited2 = new HashSet<>();
        int res=-1, dist = 0, min=Integer.MAX_VALUE;
    
        for (int i=node2; i>=0 && !visited2.contains(i); i=edges[i]) {
            
            if(visited1.containsKey(i)){
                int curr = Math.max(dist, visited1.get(i));
                if(res==-1 || curr<=min){
                    res = curr==min ? Math.min(res, i) : i;
                    min = curr;
                }
                
            }
            dist++;
            visited2.add(i);
        }
        
        return res;
    }
}