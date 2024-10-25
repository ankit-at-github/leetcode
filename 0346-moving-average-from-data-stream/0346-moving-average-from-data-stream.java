class MovingAverage {
    List<Integer> nums;
    int window, left;
    double sum;
    public MovingAverage(int size) {
        nums = new ArrayList<>();
        left = 0;
        sum = 0;
        window = size;
    }
    
    public double next(int val) {
        sum+=val;
        nums.add(val);
        if(nums.size() > window){
            sum-=nums.get(left);
            left++;
        }
        return sum/(nums.size()-left);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */