class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSoFar = 0, minSoFar = 0, sum = 0;
        int maxSum = nums[0], minSum = nums[0];
        for (int num : nums) {
            maxSoFar = Math.max(maxSoFar, 0) + num;
            maxSum = Math.max(maxSum, maxSoFar);
            minSoFar = Math.min(minSoFar, 0) + num;
            minSum = Math.min(minSum, minSoFar);
            sum += num;  
        }
        return sum == minSum ? maxSum : Math.max(maxSum, sum - minSum);
    }
}