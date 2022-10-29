class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int x : nums) total+=x;
        
        int s2 = total-target;
        if(s2 < 0 || s2%2!=0) return 0;
        
        int n = nums.length;
        int k = s2/2;
        int[][] dp = new int[n][k+1];
        
        if(nums[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;
        
        if(nums[0]!=0 && nums[0] <= k) dp[0][nums[0]] = 1;
        
        for(int index=1; index<n; index++)
        {
            for(int tar=0; tar<k+1; tar++)
            {
                int notTake = dp[index-1][tar];
                
                int take = 0;
                if(nums[index] <= tar) take = dp[index-1][tar-nums[index]];
                
                dp[index][tar] = notTake+take;
            }
        }
        
        return dp[n-1][k];
    }
}