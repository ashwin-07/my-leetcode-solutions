class Solution {
    
    int binarySearch(int[] arr, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
    
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int lisLength = 0; //longest increasing subsequence length
        int res[] = new int[n];
        int lis[] = new int[n];
        
        for (int i = 0; i < n; ++i) {
            int idx = binarySearch(lis, obstacles[i], 0, lisLength);
            res[i] = idx + 1;
            
            if (idx == lisLength) {
                lisLength++;
            }
            lis[idx] = obstacles[i];
        }
        
        return res;
    }
    
}