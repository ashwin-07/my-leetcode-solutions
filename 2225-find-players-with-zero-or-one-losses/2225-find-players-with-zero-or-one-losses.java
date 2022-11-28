class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        Map<Integer, Integer> lossesForElemMap = new HashMap<>();
        
        
        for (int[] match : matches) {
            lossesForElemMap.put(match[0], lossesForElemMap.getOrDefault(match[0], 0));
            lossesForElemMap.put(match[1], lossesForElemMap.getOrDefault(match[1], 0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>(2);
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        
        
        for (Integer element : lossesForElemMap.keySet()) {
            if (lossesForElemMap.get(element) <= 1) {
                result.get(lossesForElemMap.get(element)).add(element);
            }
        }

        Collections.sort(result.get(0));
        
        Collections.sort(result.get(1));

        return result;
        
    }
}