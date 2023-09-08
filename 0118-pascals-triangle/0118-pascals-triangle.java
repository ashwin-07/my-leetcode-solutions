class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> pascal = new ArrayList<>();
        
        List<Integer> currRow = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            currRow.add(0, 1);
            for (int j = 1; j < currRow.size()-1; j++) {
                currRow.set(j, currRow.get(j) + currRow.get(j+1));
            }
            pascal.add(new ArrayList<>(currRow));
        }
        
        return pascal;
        
    }
}