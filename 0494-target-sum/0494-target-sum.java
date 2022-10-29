class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int x : nums) total+=x;
        
        int s2 = total-target;
        if(s2 < 0 || s2%2!=0) return 0;
        
        return count(nums.length-1, nums, s2/2);
    }
    public int count(int index, int[] nums, int target)
    {
        if(index == 0)
        {
            if(target == 0 && nums[0] == 0) return 2;
            if(target == 0 || nums[0] == target) return 1;
            return 0;
        }
        
        int notTake = count(index-1, nums, target);
        
        int take = 0;
        if(nums[index] <= target) take = count(index-1, nums, target-nums[index]);
        
        return notTake+take;
    }
}