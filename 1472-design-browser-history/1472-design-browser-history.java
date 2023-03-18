class BrowserHistory {
    
    List<String> browsingHistory;
    int currPtr, recentPtr;
    

    public BrowserHistory(String homepage) {
        browsingHistory = new ArrayList<String>(Arrays.asList(homepage));
        currPtr = 0; 
        recentPtr = 0;
    }
    
    public void visit(String url) {
        currPtr++;
        if (browsingHistory.size() > currPtr) {
            browsingHistory.set(currPtr, url);
        } else {
            browsingHistory.add(url);
        }
        recentPtr = currPtr;  
    }
    
    public String back(int steps) {
        currPtr = Math.max(0, currPtr - steps);
        return browsingHistory.get(currPtr);        
    }
    
    public String forward(int steps) {
        currPtr = Math.min(recentPtr, currPtr + steps);
        return browsingHistory.get(currPtr);        
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */