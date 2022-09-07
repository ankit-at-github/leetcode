class MovingAverage {
    List<Integer> l = new ArrayList<>();
    int window = 0;
    int left  = 0;
    double sum = 0;
    public MovingAverage(int size) {
        window = size;
    }
    
    public double next(int val) {
        sum+=val;
        l.add(val);
        if(l.size() <= window) return sum/l.size();
        sum-=l.get(left++);
        return sum/window;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */