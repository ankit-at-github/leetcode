class Solution {
    public boolean canPartition(int[] nums) {
        int s = 0;
        for(int n : nums) s+=n;
        
        if(s%2 != 0) return false;
        
        int target = s/2;
        
        Boolean[][] memo = new Boolean[nums.length][target+1];
        
        return subset(nums.length-1, nums, target, memo);
    }
    public boolean subset(int index, int[] nums, int target, Boolean[][] memo)
    {
        if(target == 0) return true;
        
        if(index == 0) return nums[0] == target;
        
        if(memo[index][target] != null) return memo[index][target];
        
        boolean notTake = subset(index-1, nums, target, memo);
        boolean take = false;
        if(nums[index] <= target) take = subset(index-1, nums, target-nums[index], memo);
        
        return memo[index][target] = (notTake||take);
    }
}