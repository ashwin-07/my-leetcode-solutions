class Solution {
 public List<List<Integer>> findSubsequences(int[] nums) {
     
        Set<List<Integer>> result = new HashSet<>();
        find(0, nums, new LinkedList<>(), result);
        return new ArrayList<>(result);
    }

    void find(int start, int[] nums, LinkedList<Integer> list, Set<List<Integer>> result) {
        
        if (list.size() >= 2) {
            result.add(new ArrayList<>(list));
        }
        
        for (int i = start; i < nums.length; i++) {
            if (list.isEmpty() || list.getLast() <= nums[i]) {
                list.add(nums[i]);
                find(i + 1, nums, list, result);
                list.removeLast();
            }
        }
    }
}