class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int[] resultArr = new int[2];
        for (int num:nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                resultArr[0] = Math.abs(num);
            }
            else {
                nums[Math.abs(num) - 1] *= -1;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                resultArr[1] = i + 1;
                break;
            }
        }
        
        return resultArr;
        
    }
}


// 4 2 1 1

// 2 -1 2 3 4

// 1 2 3 1

// 1 -2 -3 1