class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int x : nums) st.add(x);
        
        int count = 0;
        int maxi = 0;
        for(int x : nums)
        {
            if(!st.contains(x-1))
            {
                while(!st.isEmpty() && st.contains(x++)) count++;
                maxi = Math.max(maxi, count);
                count = 0;
            }
        }
        return maxi;
    }
}