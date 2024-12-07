class MinStack {
    Node head;
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(head == null)
            head = new Node(val, val, null);
        else
            head = new Node(val, Math.min(val, head.min), head);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}
class Node{
    int val;
    int min;
    Node next;
    Node(int _val, int _min, Node _next){
        val = _val;
        min = _min;
        next = _next;
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