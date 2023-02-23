class Solution {
    
    class ProjectDetails {
        int capital, profit;

        ProjectDetails(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }  
    }
    
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        PriorityQueue<ProjectDetails> capitalMinHeap = new PriorityQueue<>((a, b) -> (a.capital - b.capital));
        PriorityQueue<ProjectDetails> profitsMaxHeap = new PriorityQueue<>((a, b) -> (b.profit - a.profit));
        
        for (int i = 0; i < profits.length; i++) {
            capitalMinHeap.add(new ProjectDetails(capital[i], profits[i]));
        }
        
        for (int i = 0; i < k; i++) {
            
            while (!capitalMinHeap.isEmpty() && capitalMinHeap.peek().capital <= w) {
                profitsMaxHeap.add(capitalMinHeap.poll());
            }
            
            if (profitsMaxHeap.isEmpty()) break;
            
            w += profitsMaxHeap.poll().profit;
            
        }
        
        return w;
        
    }
}