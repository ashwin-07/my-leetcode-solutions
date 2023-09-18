class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] -a[1]);
        
        int[] weakestIdxs = new int[k];
        
        for (int i = 0; i < mat.length; i++) {
            int zeroStartIdx = findNumOfOnes(mat[i]);
            maxHeap.add(new int[]{zeroStartIdx, i});
            
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }  
        }
        
        while (k > 0) {
            weakestIdxs[--k] = maxHeap.poll()[1];
        }
        
        return weakestIdxs;
    }
    
    int findNumOfOnes(int[] row) {
        
        int left = 0;
        int right = row.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (row[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}