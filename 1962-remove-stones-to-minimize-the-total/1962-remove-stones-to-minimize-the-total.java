class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        Queue<Integer> heap = new PriorityQueue<>((a,b) -> b-a);
        int result = 0;
        
        for (int pile:piles) {
            heap.add(pile);
            result+=pile;
        }
        
        while (k-- > 0) {
            int numCeil = (int)Math.ceil(heap.peek()/2.0);
            int numFloor = (int)Math.floor(heap.poll()/2.0);
            heap.offer(numCeil);
            result-=numFloor;
        }
        
        return result;
        
    }
}