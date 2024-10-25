class MovingAverage {
    int[] nums;
    int window, left = 0;
    double sum = 0;
    public MovingAverage(int size) {
        nums = new int[size];
        window = size;
    }
    
    public double next(int val) {
        sum+=val;
        if(nums.length == window){
            sum-=nums[left%window];
            nums[left%window] = val;
            left++;
        }
        return sum/Math.min(left, window);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */