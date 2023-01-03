class Solution {
    public int search(int[] nums, int target) {
        

        int lo = 0, hi = nums.length-1;
        
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[hi]) {
                lo = mid+1;
            }
            else {
                hi = mid;
            } 
        }
        
        int rotIdx = lo;
        lo = 0; hi = nums.length-1;
        
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            int rotatedMid = (mid + rotIdx) % nums.length;
            if (nums[rotatedMid] == target) {
                return rotatedMid;
            }
            else if (nums[rotatedMid] < target) {
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
        }
        
        return -1;
        
    }
}

