class SmallestInfiniteSet {
    
    TreeSet<Integer> sortedSet;
    int currCount = 0;

    public SmallestInfiniteSet() {
        sortedSet = new TreeSet<>();
        currCount = 1;
    }
    
    public int popSmallest() {
        if (sortedSet.isEmpty()) {
            return currCount++;
        }
        return sortedSet.pollFirst(); 
    }
    
    public void addBack(int num) {
         if (num < currCount) {
            sortedSet.add(num);
         }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */