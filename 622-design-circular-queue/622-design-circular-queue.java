class MyCircularQueue {
    int[] q;
    int head;
    int tail;
    public MyCircularQueue(int k) {
        q = new int[k];
        head = 0;
        tail = 0;
    }
    
    public boolean enQueue(int value) {
        if(tail == q.length && head == 0) return false;
        
        q[tail++] = value;
        
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        while(head < tail-1)
        {
            q[head] = q[head+1];
            head++;
        }
        head = 0;
        tail--;
        return true;
    }
    
    public int Front() {
        if(head == tail) return -1;
        return q[head];
    }
    
    public int Rear() {
        if(head == tail) return -1;
        return q[tail-1];
    }
    
    public boolean isEmpty() {
        if(head == tail) return true;
        return false;
    }
    
    public boolean isFull() {
        if(tail == q.length) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */