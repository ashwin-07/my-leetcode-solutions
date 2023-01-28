class Solution {
    public int[][] kClosest(int[][] points, int k) {
     
        
        PriorityQueue<int[]> heap = new PriorityQueue<>(k, (a,b) -> {
            
          return (b[0]*b[0] + (b[1]*b[1])) - (a[0]*a[0] + (a[1]*a[1]));   
            
        });
        
        
        for (int[] item:points) {
           
            heap.offer(item);
            if (heap.size() > k) {
                heap.poll();
            }
            
        }
        
        int[][] result = new int[heap.size()][2];
        int i = 0;
        while (!heap.isEmpty()) {
            result[i] = heap.poll();
            i++;
        }
        
        return result;
        
        
    }
}