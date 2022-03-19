class Solution {
    public int getMaxLen(int[] nums) {
        int negatives = 0;
        int max = 0;
        for(int i=0; i<nums.length; i++)
        {
            if((nums.length - i) <= max) return max; //no need to check futher if length of leftover subarray is less than max, as we have already got our max sub-array.
            if(nums[i]!=0)
            {
                negatives = nums[i] < 0 ? 1 : 0;
                max = Math.max(max, nums[i] > 0 ? 1 : 0);
                for(int j=i+1; j<nums.length; j++)
                {
                    if(nums[j] < 0) negatives++;
                    else if(nums[j] == 0) break;
                    if(negatives%2==0) max = Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }
}