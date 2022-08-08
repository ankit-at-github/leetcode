class Solution {
    public boolean validPartition(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        if(solve(nums, 0, dp) == 1) return true;
        return false;
    }
    public int solve(int[] nums, int i, int[] dp)
    {
        //index reached at last index valid partition possible
        if(i == nums.length) return 1;
        
        if(dp[i] != -1) return dp[i];
        
        if(i < nums.length-1 && nums[i] == nums[i+1])
        {
            if(solve(nums, i+2, dp) == 1) return dp[i] = 1;
            
            if(i < nums.length-2 && nums[i] == nums[i+2])
            {
                if(solve(nums, i+3, dp) == 1) return dp[i] = 1;
            }
        }
        if(i < nums.length-2 && nums[i]+1 == nums[i+1] && nums[i+1]+1 == nums[i+2])
        {
            if(solve(nums, i+3, dp) == 1) return dp[i] = 1;
        }
        return dp[i] = 0;
    }
}