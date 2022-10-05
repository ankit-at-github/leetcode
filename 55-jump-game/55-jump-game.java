class Solution {
    public boolean canJump(int[] nums) {
        return jump(0, nums, new Boolean[nums.length]);
    }
    public boolean jump(int index, int[] nums, Boolean[] dp)
    {
        if(index == nums.length-1) return true;
        
        if(dp[index] != null) return dp[index];
        
        for(int i=1; i<=nums[index]; i++)
        {
            if(jump(index+i, nums, dp))
            {
                dp[index] = true;
                return dp[index];
            }
        }
        
        dp[index] = false;
        
        return dp[index];
    }
}