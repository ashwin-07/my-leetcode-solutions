class Solution {
    public boolean removeOnes(int[][] grid) {
        
        for (int i = 1; i < grid.length; i++) {
            if (isSame(grid[0], grid[i]) || isOpposite(grid[0], grid[i])) {
                continue;
            }
            else {
                return false;
            }
        }

        return true; 
        
    }
       
    boolean isSame(int[] arr1, int[] arr2) {
        return IntStream.range(0, arr1.length).noneMatch(idx -> arr1[idx] != arr2[idx]);
    }

    boolean isOpposite(int[] arr1, int[] arr2) {
        return IntStream.range(0, arr1.length).noneMatch(idx -> arr1[idx] + arr2[idx] != 1);
    }
    
    
    
}