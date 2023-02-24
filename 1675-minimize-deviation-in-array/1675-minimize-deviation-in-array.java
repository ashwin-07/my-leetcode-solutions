class Solution {
    public int minimumDeviation(int[] nums) {
        
        PriorityQueue<Integer> maxHeap =new PriorityQueue<>((a,b)->Integer.compare(b,a)); 
        
        int minVal=Integer.MAX_VALUE;
        
        for(int num:nums) { 
            if (num%2==1) {
                num*=2; 
            }
            minVal = Math.min(minVal,num);
            maxHeap.add(num);
        } 
        

        int minDiff = Integer.MAX_VALUE;
        
        while(maxHeap.peek()%2==0) {
            
            int maxVal = maxHeap.poll(); 
            
            minDiff = Math.min(minDiff, maxVal - minVal); 
            minVal=Math.min(maxVal/2, minVal);
            
            maxHeap.add(maxVal/2);
            
        }
        
        minDiff = Math.min(minDiff, maxHeap.peek() - minVal);
        
        return minDiff;
    }
}