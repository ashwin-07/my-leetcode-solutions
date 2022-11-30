class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        Map<Integer, Integer> hMap = new HashMap<>(); 
        
        for (int i : arr) {
            hMap.put(i, hMap.getOrDefault(i, 0)+1);
        }
        
        Set<Integer> hSet = new HashSet<>(hMap.values());
        
        return hSet.size() == hMap.size();
        
    }
}