class Solution {
    public int countOdds(int low, int high) {
        high = high % 2 == 0 ? high : high + 1;
        low = low % 2 == 0 ? low : low - 1;
        return ((high - low) / 2);
    }
}


