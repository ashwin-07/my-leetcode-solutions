class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>  result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        permute(new ArrayList<>(), nums, used, result);
        
        return result;
        
    }
    
    
    public void permute(List<Integer> curr, int[] nums, boolean[] used, List<List<Integer>> result) {
        
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return; 
        }
        
        
        for (int j = 0; j < nums.length; j++) {
            
            
            if (used[j]){
                continue;
            }
            
            if (j > 0 && nums[j] == nums[j - 1] && !used[j-1]) {
                continue;
            }
            
            curr.add(nums[j]);
            used[j] = true;
            permute(curr, nums, used, result);
            curr.remove(curr.size() - 1);
            used[j] = false;
        }
        
    }
    
}