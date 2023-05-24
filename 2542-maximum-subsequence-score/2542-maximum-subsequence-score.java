class Solution {
    
    class Pair {
        int num1;
        int num2;
        Pair(int n1, int n2) {
            num1 = n1;
            num2 = n2;
        }
    }
    
    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        long result = 0;
        int n = nums1.length;
        Pair[] pairs = new Pair[n];
        
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair(nums1[i], nums2[i]);
        }
        
        Arrays.sort(pairs, (a,b) -> b.num2 - a.num2);
    
        Queue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.num1 - b.num1);
        long sumForKNums = 0;
        
        for (int i = 0; i < k; i++) {
            sumForKNums+=pairs[i].num1;
            minHeap.add(pairs[i]);    
        }
        
        result = sumForKNums * pairs[k-1].num2;
        
        for (int i = k; i < n; i++) {
            sumForKNums+=pairs[i].num1 - minHeap.poll().num1;
            minHeap.add(pairs[i]);
            long minMultiplier = pairs[i].num2;
            result = Math.max(result, minMultiplier * sumForKNums);
        }
        
        return result;
    }
}