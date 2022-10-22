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
        boolean[] prev = new boolean[k+1];
        
        prev[0] = true;
        
        if(nums[0] <= k) prev[nums[0]] = true;
        
        for(int index=1; index<n; index++)
        {
            boolean[] curr = new boolean[k+1];
            curr[0] = true;
            for(int target=1; target<k+1; target++)
            {
                boolean notTake = prev[target];
                
                boolean take = false;
                if(nums[index] <= target) take = prev[target-nums[index]];
                
                curr[target] = (notTake||take);;
            }
            prev = curr;
        }
        return prev[k];
    }
}