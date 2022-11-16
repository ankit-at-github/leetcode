class Solution {
    public int longestConsecutive(int[] nums) {
        int maxi = 0;
        Set<Integer> st = new HashSet<>();
        for(int n : nums) st.add(n);
        
        for(int i=0; i<nums.length; i++)
        {
            int val = nums[i];
            if(!st.contains(val-1))
            {
                while(st.contains(val)) val = val+1;
                maxi = Math.max(maxi, val - nums[i]);
            }
        }
        return maxi;
    }
}