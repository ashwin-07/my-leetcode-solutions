class MyStack {
    
    Queue<Integer> queue;
    int top = 0;

    public MyStack() {
       queue = new LinkedList<>(); 
    }
    
    public void push(int x) {
        queue.add(x);
        top = x;
    }
    
    public int pop() {
        int size = queue.size();
        
        while (size > 1) {
            int val = queue.poll();
            queue.add(val);
            top = val;
            size--;
        }
        
        return queue.poll();
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */