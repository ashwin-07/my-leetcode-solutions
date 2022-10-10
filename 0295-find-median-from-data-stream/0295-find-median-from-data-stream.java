class MedianFinder {
    
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap =  new PriorityQueue<Integer>((a,b) ->  b - a);
    }
    
    public void addNum(int num) {
       
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
        
        if ((minHeap.size() + maxHeap.size())%2 == 1) {
            return (double) maxHeap.peek();
        }
        else {
            return (double)(maxHeap.peek()+minHeap.peek()) / 2.0;
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */