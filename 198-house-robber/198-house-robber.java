class Solution {
    int maxi = Integer.MIN_VALUE;
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        
        return solve(0, nums, memo);
    }
    public int solve(int index, int[] nums, int[] memo)
    {
        //no house to examine
        if(index >= nums.length)
        {
            return 0;
        }
        
        if(memo[index] != -1) return memo[index];
        
        int ans = Math.max(nums[index] + solve(index+2, nums, memo), solve(index+1, nums, memo));
        
        memo[index] = ans;
        
        return ans;
    }
}