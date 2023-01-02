class MyCalendar {
    
    TreeMap<Integer, Integer> calander;

    public MyCalendar() {
       calander = new TreeMap<>(); 
    }
    
    public boolean book(int start, int end) {
        
        Integer prev = calander.floorKey(start);
        Integer next = calander.ceilingKey(start);
        
        if ((prev == null || calander.get(prev) <= start) && 
            (next == null || end <= next)) {
            calander.put(start, end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */