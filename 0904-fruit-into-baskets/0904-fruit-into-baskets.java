class Solution {
    
    public int totalFruit(int[] fruits) {
      
        int continuousSegmentCount = 0;
        int earliestOfTheTwo = fruits[0];
        HashMap<Integer, Integer> fruitTypeCountMap = new HashMap<>();
        
        fruitTypeCountMap.put(fruits[0], 1);
        
        int max = 0;
        
        int i = 0;
        for (i = 1; i < fruits.length; i++) {
            fruitTypeCountMap.put(fruits[i], fruitTypeCountMap.getOrDefault(fruits[i], 0) + 1);
            
            if (fruitTypeCountMap.size() > 2) {
                max = Math.max(max, fruitTypeCountMap.get(fruits[i-1]) + 
                               fruitTypeCountMap.get(earliestOfTheTwo));
                fruitTypeCountMap.remove(earliestOfTheTwo);
                fruitTypeCountMap.put(fruits[i-1], continuousSegmentCount);
                earliestOfTheTwo = fruits[i-1];
                continuousSegmentCount = 1;
            }
            else {
                if (fruits[i] == fruits[i-1]) {
                    continuousSegmentCount++;
                }
                else {
                    earliestOfTheTwo = fruits[i-1];
                    continuousSegmentCount=1;
                }
            }
        }
        
        
        int earliestCount = fruits[i-1] == earliestOfTheTwo ? 0 : fruitTypeCountMap.get(earliestOfTheTwo);
        
        max = Math.max(max, fruitTypeCountMap.get(fruits[i-1]) + earliestCount);
        
        return max;
        
    }
}




    