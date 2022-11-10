class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int x : nums) total+=x;
        
        int tar = total+target;
        
        if(tar%2 != 0) return 0;
        
        return ways(nums.length-1, nums, tar/2);
    }
    public int ways(int index, int[] nums, int target)
    {
        if(index == 0)
        {
            if(target == 0 && nums[0] == 0) return 2;
            if(target == 0 || nums[0] == target) return 1;
            return 0;
        }
        
        int notTake = ways(index-1, nums, target);
        
        int take = 0;
        if(nums[index] <= target) take = ways(index-1, nums, target-nums[index]);
        
        return notTake+take;
    }
}