class Solution {
    public int minimumRounds(int[] tasks) {
                
       Map<Integer, Integer> difficultyLvlCounts = new HashMap<>();

        for (int task:tasks) {
            difficultyLvlCounts.put(task, difficultyLvlCounts.getOrDefault(task, 0)+1);
        }

        int sum = 0;
        
        for (int count:difficultyLvlCounts.values()) {
            if (count == 1) {
                return -1;
            }
            sum+=((count+2)/3);
        }
        return sum;
    }
}