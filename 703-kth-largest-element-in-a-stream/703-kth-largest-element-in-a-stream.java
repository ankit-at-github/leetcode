class KthLargest {
    Queue<Integer> queue;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>((a,b) -> a-b);
        for(int x : nums) queue.add(x);
        int size = queue.size();
        int remove = size - k;
        while(remove > 0)
        {
            queue.poll();
            remove--;
        }
    }
    
    public int add(int val) {
        if(k > queue.size())
        {
            queue.add(val);
            return queue.peek();
        }
        else
        {
            if(val < queue.peek()) return queue.peek();
            else
            {
                queue.poll();
                queue.add(val);
                return queue.peek();
            }
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */