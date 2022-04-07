class NumArray {

    int[] result;
    public NumArray(int[] nums) {
        result = nums;
    }
    
    public int sumRange(int left, int right) {
        int sum=0;
        for(int i=left; i<=right; i++) sum+=result[i];
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */