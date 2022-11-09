class SpanItem {
    
    int price;
    int streak; //continuous days of stock price was less than or equal to today's price.
    
    SpanItem(int price, int streak) {
        this.price = price;
        this.streak = streak;
    }
}

class StockSpanner {
    
    Stack<SpanItem> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        
        int currStreak = 1;
        while (!stack.isEmpty() && price >= stack.peek().price) {
            currStreak+=stack.pop().streak;
        }
        stack.push(new SpanItem(price, currStreak));
        return currStreak;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */