class Solution {
    public double average(int[] salary) {
        
        double sum = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        for (int num : salary) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return (sum - min - max) / (salary.length - 2);   
    }
}