class SparseVector {
    Map<Integer, Integer> sparse = new HashMap<>();
    SparseVector(int[] nums) {
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]!=0)
            {
                sparse.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        if(sparse.size() == 0 || vec.sparse.size()==0) return 0;
        int sum = 0;
        for(int key : sparse.keySet())
        {
            if(vec.sparse.containsKey(key))
            {
                sum+=sparse.get(key)*vec.sparse.get(key);
            }
            else sum+=0;
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);