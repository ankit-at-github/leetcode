class MyCircularQueue {
    int[] q;
    int front, rear, k, n;
    public MyCircularQueue(int k) {
        q = new int[k];
        front = 0;
        rear = -1;
        this.k = k;
        n = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        
        rear = (rear + 1) % k;
        q[rear] = value;
        
        n++;
        
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        
        front = (front + 1) % k;
        
        n--;
        
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        front = front % k;
        return q[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        rear = rear % k;
        return q[rear];
    }
    
    public boolean isEmpty() {
        if(n == 0) return true;
        return false;
    }
    
    public boolean isFull() {
        if(n == k) return true;
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