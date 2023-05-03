class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        Set<Integer> nums1Set = Arrays.stream(nums1)
                                      .boxed()
                                      .collect(Collectors.toSet());
        
        Set<Integer> nums2Set = Arrays.stream(nums2)
                                      .filter(n -> !nums1Set.contains(n))
                                      .boxed()
                                      .collect(Collectors.toSet());
        
        Arrays.stream(nums2).forEach(nums1Set::remove);
        return Arrays.asList(new ArrayList<>(nums1Set), new ArrayList<>(nums2Set));
    }
}