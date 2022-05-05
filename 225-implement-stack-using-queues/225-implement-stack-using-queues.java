class MyStack {

    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        int r = top();
        q.remove(r);
        return r;
    }
    
    public int top() {
        int value = 0;
        for(int e : q)
        {
            value = e;
        }
        return value;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */