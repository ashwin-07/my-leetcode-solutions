class Solution {
    public int minimumRounds(int[] tasks) {
                
       Map<Integer, Integer> difficultyLvlCounts = new HashMap<>();

        for (int task:tasks) {
            difficultyLvlCounts.put(task, difficultyLvlCounts.getOrDefault(task, 0)+1);
        }

        int sum = 0;
        
        for (int diffLevel:difficultyLvlCounts.keySet()) {
            
            int count = difficultyLvlCounts.get(diffLevel);
            
            if(count < 2) {
                return -1;
            }
            
            int countMod3 = count % 3;
            int countBy3 = count / 3;
            
            if (countMod3 == 0) {
                sum+=countBy3;
            }
            else if (countMod3 == 1) {
                int noOf3s = countBy3 - 1;
                int noOf2s = (count - (3 * noOf3s))/2;
                sum+=noOf3s+noOf2s;
            }
            else {
                sum+=countBy3+1;
            }
        }
        return sum;
    }
}