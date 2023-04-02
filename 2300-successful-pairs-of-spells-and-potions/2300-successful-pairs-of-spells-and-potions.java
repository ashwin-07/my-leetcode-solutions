class Solution {    
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        
        int potionsSize = potions.length;
        int maxPotionStrength = potions[potionsSize - 1];
        
        for (int i = 0; i < spells.length; i++) {
            
            //min required potions to satisfy successful pair condition
            int minRqdPotionStrength = (int)Math.ceil((double)success/(double)spells[i]);

            if (minRqdPotionStrength > maxPotionStrength) {
                result[i] = 0;
                continue;
            }

            int lowerBoundIdx = findLowerBound(potions, minRqdPotionStrength);
            result[i] = potionsSize - lowerBoundIdx;
        }

        return result;
    }
    
    int findLowerBound(int[] potions, int val) {
        int l = 0, r = potions.length;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (potions[mid] < val) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}