class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int sumGas = 0, sumCost = 0;
        int bal = 0;
        int start = 0;
        
        for (int i = 0; i < gas.length; i++) {
            
            sumGas+=gas[i];
            sumCost+=cost[i];
            
            bal+=gas[i] - cost[i];
            
            if (bal < 0) {
                start = i+1;
                bal = 0;
            }
            
        }
        
        return sumGas < sumCost ? -1 : start;
        
        
    }
}