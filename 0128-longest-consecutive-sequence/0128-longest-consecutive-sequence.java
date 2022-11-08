class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int x : nums) st.add(x);
        
        int maxi = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(st.contains(nums[i]-1)) continue;
            
            int val = nums[i];
            int count = 0;
            while(st.contains(val++)) count++;
            
            maxi = Math.max(maxi, count);
        }
        return maxi;
    }
}