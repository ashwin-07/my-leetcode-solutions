/*

ID: 1
Difficulty: Easy
Topic: Arrays, HashTable

#Description
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target


*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> elements = new HashMap<Integer, Integer>();
        int start = 0,end = 0;
        
        for (int i =0; i < nums.length; i++){ 
            int complement = target - nums[i];
            if (elements.containsKey(complement)) {
                start = elements.get(complement);
                end = i;
                break;
            }
            elements.put(nums[i], i);  
        }
        
        return new int[]{start,end};
    }
}