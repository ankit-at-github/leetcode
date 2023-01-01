class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> st = new HashSet<>();
        
        for(int i=0; i<nums.length; i++)
        {
            if(st.contains(nums[i])) return true;
            
            st.add(nums[i]);
            
            if(st.size() > k) st.remove(nums[i-k]);
            
        }
        return false;
    }
}