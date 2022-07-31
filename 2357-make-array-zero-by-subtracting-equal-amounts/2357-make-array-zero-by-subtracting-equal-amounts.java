class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int x : nums)
        {
            if(x > 0) st.add(x);
        }
        return st.size();
    }
}