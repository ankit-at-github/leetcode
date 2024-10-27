class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> st = new HashSet<>();
        for(int n : nums) st.add(n);
        int count = 0;
        int maxi = 0;
        for(int n : nums){
            if(!st.contains(n-1)){
                while(!st.isEmpty() && st.contains(n++)) count++;
                maxi = Math.max(maxi, count);
                count = 0;
            }
        }
        return maxi;
    }
}