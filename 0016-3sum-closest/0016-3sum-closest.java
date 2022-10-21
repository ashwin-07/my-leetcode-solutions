class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        int result = 0;
        int i = 0;
        while(i < nums.length - 2) {
            
            // while (i != 0 && nums[i] == nums[i - 1]) {
            //     i++;
            // }
            
            int initial = nums[i];
            int lptr = i + 1;
            int hptr = nums.length - 1;
            
            while (lptr < hptr ) {
                

                
                int sum = initial + nums[lptr] + nums[hptr];
                                // System.out.println(initial +" "+nums[lptr]+" "+nums[hptr]+" "+Math.abs(sum - target)+" "+closestSum);
                if (sum - target == 0) {
                    return sum;
                }
                else if (sum - target < 0) {
                    lptr++;
                }
                else {
                    hptr--;
                }
                
                if (Math.abs(sum - target) < closestSum) {
                    closestSum = Math.abs(sum - target);
                    result = sum;
                }
            }
            i++;
            
        }
        return result;
        
    }
}