class Solution {
    public boolean canPartition(int[] nums) {
        int s = 0;
        for(int n : nums) s+=n;
        
        if(s%2 != 0) return false;
        
        return subset(nums, s/2);
    }
    public boolean subset(int[] nums, int k)
    {
        int n = nums.length;
        boolean[][] dp = new boolean[n][k+1];
        
        for(int index=0; index<n; index++) dp[index][0] = true;
        
        for(int index=1; index<n; index++)
        {
            for(int target=1; target<k+1; target++)
            {
                boolean notTake = dp[index-1][target];
                boolean take = false;
                
                if(nums[index] <= target) take = dp[index-1][target-nums[index]];
                
                dp[index][target] = (notTake||take);;
            }
        }
        return dp[n-1][k];
    }
}