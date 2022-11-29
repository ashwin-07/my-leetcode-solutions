class RandomizedSet {
    
    private Map<Integer, Integer> elementsAndIndex;
    private List<Integer> elements; 
    private Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        elementsAndIndex = new HashMap<>();
        elements = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (elementsAndIndex.containsKey(val)){
            return false;
        }
        elementsAndIndex.put(val, elements.size());
        elements.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (elementsAndIndex.containsKey(val)){
            int index = elementsAndIndex.get(val);
            int n = elements.size() - 1;
            if (index < n) {
                int lastElement = elements.get(n);
                elements.set(index, lastElement);
                elementsAndIndex.put(lastElement, index);
            }
            elements.remove(n);
            elementsAndIndex.remove(val);
            return true;
        }
        return false;
        
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return elements.get(rand.nextInt(elements.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */