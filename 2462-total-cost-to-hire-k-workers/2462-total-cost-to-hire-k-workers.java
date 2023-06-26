class Solution {
    
    public long totalCost(int[] costs, int k, int candidates) {
        
        Queue<Integer> firstKHeap = new PriorityQueue<Integer>();
        Queue<Integer> lastKHeap = new PriorityQueue<Integer>();
        
        int fptr = 0, lptr = costs.length - 1;
        
        long totalCost = 0;
        
        while (fptr < candidates) {
            firstKHeap.add(costs[fptr]);
            fptr++;
        }
        
        while (lptr >= Math.max(costs.length - candidates, fptr)) {
            lastKHeap.add(costs[lptr]);
            lptr--;
        }
        
        
        for (int i = 0; i < k; i++) {
            if (lastKHeap.isEmpty() || !firstKHeap.isEmpty() 
                && firstKHeap.peek() <= lastKHeap.peek()) {
                totalCost+=firstKHeap.poll();
                if (fptr <= lptr) {
                    firstKHeap.add(costs[fptr]);
                    fptr++;
                }
            } else {
                totalCost+=lastKHeap.poll();
                if (fptr <= lptr) {
                    lastKHeap.add(costs[lptr]);
                    lptr--;
                }
            }
        }
        return totalCost;
    }
}
