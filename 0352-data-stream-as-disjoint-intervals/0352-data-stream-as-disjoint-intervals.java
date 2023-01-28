class SummaryRanges {

    private Set<Integer> numsSet;

    public SummaryRanges() {
        numsSet = new TreeSet<>();
    }
    
    public void addNum(int value) {
        numsSet.add(value);
    }
    
    public int[][] getIntervals() {
        if (numsSet.isEmpty()) {
            return new int[0][2];
        }
        List<int[]> intervals = new ArrayList<>();
        int left = -1, right = -1;
        for (int num : numsSet) {
            if (left < 0) {
                left = num;
                right = num;
            } else if (num == right + 1) {
                right = num;
            } else {
                intervals.add(new int[] {left, right});
                left = num;
                right = num;
            } 
        }
        intervals.add(new int[] {left, right});
        return intervals.toArray(new int[0][]); 
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */