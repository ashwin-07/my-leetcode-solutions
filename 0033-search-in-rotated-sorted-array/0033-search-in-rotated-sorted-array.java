class Solution {
    public int search(int[] nums, int target) {
        
        int lo = 0, hi = nums.length-1;
        
//         if (nums.length == 1 &&) {
//             return 0;
//         }
        
        while (lo < hi) {
            
            int mid = (hi + lo) >> 1;
            
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > nums[hi]) {
                lo = mid+1;
            }
            else {
                hi = mid;
            }
            
        }
        
        
        int rotInd = lo;
        lo = 0;
        hi = nums.length-1;
        
        
        while (lo <= hi) {
            int mid = (hi + lo) >> 1;
            
            int indx = (rotInd + mid) % nums.length;
            
            if (nums[indx] == target) {
                return indx;
            }
            else if (nums[indx] < target) {
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
            
        }
        
        return -1;
        
    }
}