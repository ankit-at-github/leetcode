class SparseVector {
    Map<Integer, Integer> map = new HashMap<>();
    int total = 0;
    SparseVector(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0) map.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        for(int key : map.keySet()){
            if(vec.map.containsKey(key))
                total+=map.get(key) * vec.map.get(key);
        }
        return total;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);