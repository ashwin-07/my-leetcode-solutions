class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums.length == 0) {
            return result;
        }
        
        //num1 and num2 are numbers which are most and second most occuring, 
        //these are the potential candidates
        int num1 = nums[0], count1 = 0, num2 = nums[0], count2 = 0;
        
        for (int num: nums) {          
            if(num == num1){
                count1++;
            }
            else if (num == num2){
                count2++;
            }
            else if (count1 == 0) {
                num1 = num;
                count1++;
            }
            else if (count2 == 0) {
                num2 = num;
                count2++;
            }
            else {
                count1--;
                count2--;
            }    
        }
        
        //checking if the most and second most occuring number has count greater than n/3
        count1 = 0;
        count2 = 0;

        for (int num:nums) {
            if (num == num1) {
                count1++;
            }
            else if (num == num2) {
                count2++;
            }
        }        
        
        if (count1 > nums.length/3) {
            result.add(num1);
        }
        if (count2 > nums.length/3) {
            result.add(num2);
        }
        
        return result;
    }
}