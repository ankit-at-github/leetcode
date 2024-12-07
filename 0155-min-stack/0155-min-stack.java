class MinStack {
    Stack<Integer> st;
    Stack<Integer> minStack;
    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minStack.isEmpty() || val < minStack.peek()) minStack.push(val);
        else{
            Stack<Integer> tempStack = new Stack<>();
            while(!minStack.isEmpty() && minStack.peek() < val){
                tempStack.push(minStack.pop());
            }
            minStack.push(val);
            while(!tempStack.isEmpty()){
                minStack.push(tempStack.pop());
            }
        }
    }
    
    public void pop() {
        int val = st.pop();
        Stack<Integer> tempStack = new Stack<>();
        while(!minStack.isEmpty() && minStack.peek() != val){
            tempStack.push(minStack.pop());
        }
        minStack.pop();
        while(!tempStack.isEmpty()){
            minStack.push(tempStack.pop());
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */