class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> permuts = new ArrayList();
        findAllPermutations(nums, 0, nums.length - 1, permuts);
        return permuts;
    }
    
    
    void findAllPermutations(int[] nums, int l, int r, List<List<Integer>> permuts) {
        
        if (l == r) {
            permuts.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        
        for (int i = l; i <= r; i++) {
            swap(nums, i, l);
            findAllPermutations(nums, l+1, r, permuts);
            swap(nums, i, l);       
        }
    }
    
    void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    
}