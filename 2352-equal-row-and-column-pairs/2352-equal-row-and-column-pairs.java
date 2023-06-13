class Solution {
    public int equalPairs(int[][] grid) {
        int matchCount = 0;
        int n = grid.length;

        Map<String, Integer> rowStringCounts = new HashMap<>();
        
        for (int[] row : grid) {
            String rowString = Arrays.toString(row);
            int rowStringCount = rowStringCounts.getOrDefault(rowString, 0);
            rowStringCounts.put(rowString, rowStringCount+1);
        }

        for (int i = 0; i < n; i++) {
            int[] colElements = new int[n];
            for (int j = 0; j < n; j++) {
                colElements[j] = grid[j][i];
            }
            String colString = Arrays.toString(colElements);
            matchCount += rowStringCounts.getOrDefault(colString, 0);
        }

        return matchCount;
    }
}