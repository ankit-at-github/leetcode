class CustomStack {
    Stack<Integer> st;
    int maxSize;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        st = new Stack<>();
    }
    
    public void push(int x) {
        if(st.size() < maxSize) st.push(x);
    }
    
    public int pop() {
        if(!st.isEmpty()) return st.pop();
        else return -1;
    }
    
    public void increment(int k, int val) {
        Stack<Integer> temp = new Stack<>();
        while(!st.isEmpty()) temp.push(st.pop());
        int increment = Math.min(k, temp.size());
        while(!temp.isEmpty())
        {
            if(k > 0) st.push(temp.pop()+val);
            else st.push(temp.pop());
            k--;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */