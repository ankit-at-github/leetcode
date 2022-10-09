class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        return Math.max(maxProfit(nums, 0, nums.length-1), maxProfit(nums, 1, nums.length));
    }
    public int maxProfit(int[] nums, int start, int end)
    {
        int prev1 = nums[start];
        int prev2 = 0;
        for(int i=start; i<end; i++)
        {
            int pick = nums[i];
            
            if(i > start+1) pick+=prev2;
            
            int notpick = prev1;
            
            int current = Math.max(pick, notpick);
            
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}