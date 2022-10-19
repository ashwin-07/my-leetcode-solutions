class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> list = new LinkedList<String>();
        
        for (String word:words) {
            map.put(word,map.getOrDefault(word, 0)+1);
        }
        
        PriorityQueue<String> heap = new PriorityQueue<String>((a, b) -> {
            return map.get(a) == map.get(b) ?  b.compareTo(a) :  map.get(a) - map.get(b);
        });
        
        for (Map.Entry<String, Integer> entry: map.entrySet()){
            
            heap.offer(entry.getKey());
            if (heap.size() > k){
                heap.poll();
            }
            
        }
        
        while (!heap.isEmpty()) {
            list.add(0, heap.poll());
        }
        
        return list;
        
        
        
    }
}