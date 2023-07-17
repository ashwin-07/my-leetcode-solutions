class Solution {
    
    private int getNext(int n) {
        int sum = 0;
        
        while (n > 0) {
            int mod = n%10;
            n/=10;
            sum+=(mod*mod);
        }
        return sum;
    }
    
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
}