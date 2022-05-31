class Solution {
    public int maxSubArray(int[] nums) {
        int maxi = nums[0];
        int sum = 0;
        for(int i=0; i<nums.length; i++)
        {
            sum+=nums[i];
            sum = Math.max(nums[i], sum);
            maxi = Math.max(maxi, sum);
        }
        return maxi;
    }
}