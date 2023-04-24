class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>( (a,b) -> b-a);
        
        for (int stone:stones) {
            pq.add(stone);
        }
        
        while (pq.size() > 1){
            
            int bigStone = pq.poll();
            int smallStone = pq.poll();
            
            int diff = bigStone - smallStone;
            if (diff > 0)
                pq.add(diff);
            
        }
        
        return pq.isEmpty() ? 0 : pq.poll();
        
    }
}