class BrowserHistory {

    Map<Integer, String> visitt = new HashMap<>();
    int index = 0;
    public BrowserHistory(String homepage) {
        visitt.put(0, homepage);
    }
    
    public void visit(String url) {
        index++;
        visitt.put(index, url);
        int i = index+1;
        while(visitt.containsKey(i)) visitt.remove(i++);
    }
    
    public String back(int steps) {
        while(index > 0 && steps > 0)
        {
            steps--;
            index--;
        }
        return visitt.get(index);
    }
    
    public String forward(int steps) {
        while(index < visitt.size()-1 && steps > 0)
        {
            steps--;
            index++;
        }
        return visitt.get(index);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */