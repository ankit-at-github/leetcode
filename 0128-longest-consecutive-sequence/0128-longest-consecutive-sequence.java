class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int x : nums) st.add(x);
        
        int maxi = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(!st.contains(nums[i]-1))
            {
                int val = nums[i];
                while(st.contains(val))
                {
                    val+=1;
                }
                maxi = Math.max(maxi, val-nums[i]);
            }
        }
        return maxi;
    }
}