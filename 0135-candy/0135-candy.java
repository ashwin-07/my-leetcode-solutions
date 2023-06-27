class Solution {
    public int candy(int[] ratings) {
        
        int n = ratings.length;
        int[] candies = new int[n];
        
        Arrays.fill(candies, 1);
        
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]){
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        for (int i = n-1; i > 0; i--) {
            if (ratings[i-1] > ratings[i]) {
                candies[i - 1] = Math.max(candies[i]+1, candies[i - 1]);
            }
        }
        
        int sum = 0;
        for (int i : candies) {
            sum+=i;
        }
        
        return sum;
    }

}