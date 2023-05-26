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