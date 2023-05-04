class Solution {
    public String predictPartyVictory(String senate) {     
        int n = senate.length();
        Queue<Integer> direQueue = new LinkedList<>();
        Queue<Integer> radQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'D') {
                direQueue.add(i);
            } else {
                radQueue.add(i);
            }
        }
        
        while (!radQueue.isEmpty() && !direQueue.isEmpty()) {
            int radIdx = radQueue.poll();
            int direIdx = direQueue.poll();
            if (direIdx < radIdx) {
                direQueue.add(direIdx + n);
            } else {
                radQueue.add(radIdx + n);
            }
        }
        
        return direQueue.isEmpty() ? "Radiant" : "Dire";
    }
}