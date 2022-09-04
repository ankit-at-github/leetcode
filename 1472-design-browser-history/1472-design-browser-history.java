class BrowserHistory {

    String[] browser = new String[5000];
    int present = 0, right = 0;
    public BrowserHistory(String homepage) {
        browser[present] = homepage;
    }
    
    public void visit(String url) {
        browser[++present] = url;
        right = present;
    }
    
    public String back(int steps) {
        present = Math.max(present-steps, 0);
        return browser[present];
    }
    
    public String forward(int steps) {
        present = Math.min(present+steps, right);
        return browser[present];
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */