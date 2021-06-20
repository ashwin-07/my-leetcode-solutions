/*
   ID: 11
   Difficulty: Easy/Medium
   Topic: Two pointers
   Description: Find two lines, which, together with the x-axis forms a container, such that the container contains the most water
*/

// time complexity O(n), space : O(1)

class Solution {
    public int maxArea(int[] height) {
        
        int first = 0, last = height.length - 1;
        
        int max = 0, area = 0;
        
        while (first < last) {
            
            if (height[first] > height[last]) {
                area = height[last] * (last - first);
                last--;
            }
            else{
                area = height[first] * (last - first);
                first++;
            }
            
            max = Math.max(area, max);
            
        }
        return max;
        
    }
}