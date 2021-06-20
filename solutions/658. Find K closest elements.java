/*
   ID: 658
   Difficulty: Medium
   Description: Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array
   Topic: Binary search, sliding window 
*/


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int left = 0, right = arr.length-k;
        
        while (left < right) {
            int mid = left + (right - left)/2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        
        return Arrays.stream(arr, left, left+k).boxed().collect(Collectors.toList());
        
        
    }
}