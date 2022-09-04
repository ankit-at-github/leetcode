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
        int b = Math.min(present, steps);
        present-=b;
        return browser[present];
    }
    
    public String forward(int steps) {
        int f = Math.min(right-present, steps);
        present+=f;
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