class Solution {
    public int minDeletionSize(String[] strs) {
        
        int count = 0;
        for (int colIdx = 0; colIdx < strs[0].length(); colIdx++) {
            for (int rowIdx = 1; rowIdx < strs.length; rowIdx++) {
                if (strs[rowIdx].charAt(colIdx) < strs[rowIdx - 1].charAt(colIdx)) {
                    count++;
                    break;
                }
            }
        }
        return count;

    }
}