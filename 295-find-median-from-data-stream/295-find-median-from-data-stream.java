class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int size;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
        size = 0;
    }
    
    public void addNum(int num) {
        size++;
        maxHeap.add(num);
        if(!minHeap.isEmpty())
        {
            if(maxHeap.peek() > minHeap.peek())
            {
                minHeap.add(maxHeap.poll());
            }
        }
        if(Math.abs(maxHeap.size() - minHeap.size()) > 1)
        {
            if(maxHeap.size() > minHeap.size()) minHeap.add(maxHeap.poll());
            else maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(size%2==0)
        {
            double median = (maxHeap.peek() + minHeap.peek())/2.0;
            return median;
        }
        else
        {
            if(maxHeap.size() > minHeap.size()) return (double)maxHeap.peek();
            else return (double)minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */