class SparseVector {
    private int[] nums;
    SparseVector(int[] nums) {
        this.nums = nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int total = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0 || vec.nums[i] == 0) continue;
            total+=nums[i] * vec.nums[i];
        }
        return total;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);