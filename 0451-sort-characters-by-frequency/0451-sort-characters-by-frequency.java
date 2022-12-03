class Solution {
    public String frequencySort(String s) {
        
        Map<Character, Integer> charFreqMap = new HashMap<>();
        
        for (char ch:s.toCharArray()) {
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0)+1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> heap = 
            new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        
        heap.addAll(charFreqMap.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            Map.Entry entry = heap.poll();
            for (int i = 0; i < (int)entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
        
    }
}