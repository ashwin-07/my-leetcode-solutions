class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        
        int[] result = new int[queries.length];
        
        Arrays.sort(nums);
        
        for (int i = 1; i < nums.length; i++) {
            nums[i]+=nums[i-1]; 
        }
        
        for (int i = 0; i < queries.length; i++) {
            result[i] = search(nums, queries[i]);
        }
        
        return result;
        
    }
    
    int search(int[] nums, int val) {
        
        int l = 0, r = nums.length - 1;
        
        while (l < r) {
            int mid = (l) + (r - l) / 2;
            
            if (nums[mid] == val) {
                return mid+1;
            }          
            if (nums[mid] < val) {
                l = mid+1;
            }
            else {
                r = mid;
            }
        }
        
        return nums[l] <= val? l+1:l;
        
    }
}



