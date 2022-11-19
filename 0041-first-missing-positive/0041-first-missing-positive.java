class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int x : nums) st.add(x);
        for(int i=1; i<Integer.MAX_VALUE; i++) if(!st.contains(i)) return i;
        return -1;
    }
}