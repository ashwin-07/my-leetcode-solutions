class LFUCache {
    
    int capacity;
    
    Map<Integer, Pair<Integer, Integer>> cache;
    
    Map<Integer, LinkedHashSet<Integer>> frequencyAndKeys;
    
    int minFreq = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        frequencyAndKeys = new HashMap<>();
        
    }
    
    void insert(int key, int value, int frequency) {
       cache.put(key, new Pair<>(value, frequency));
       frequencyAndKeys
           .computeIfAbsent(frequency, e -> new LinkedHashSet<>())
           .add(key);
    }
    
    public int get(int key) {
        
        if (!cache.containsKey(key)) {
            return -1;
        }
        
        Pair<Integer, Integer> valueAndFreq = cache.get(key);
        int frequency = valueAndFreq.getValue();
        
        LinkedHashSet<Integer> keysWithFreq = frequencyAndKeys.get(frequency);
        keysWithFreq.remove(key);
        
        if (minFreq == frequency && keysWithFreq.isEmpty()) {
            minFreq++;
        }
        
        int value = valueAndFreq.getKey();
        insert(key, value, frequency+1);

        return valueAndFreq.getKey();
        
    }

    
    public void put(int key, int value) {
        
        if (capacity <= 0) {
            return;
        }
        
        Pair<Integer, Integer> valueAndFreq = cache.get(key);
        if (valueAndFreq != null) {
            cache.put(key, new Pair<>(value, valueAndFreq.getValue()));
            get(key);
            
        }
        else {
            if (cache.size() == capacity) {
                Set<Integer> keys = frequencyAndKeys.get(minFreq);
                int keyToDelete = keys.iterator().next();
                cache.remove(keyToDelete);
                keys.remove(keyToDelete);
            }
            minFreq = 1;
            insert(key, value, 1);
        }
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */