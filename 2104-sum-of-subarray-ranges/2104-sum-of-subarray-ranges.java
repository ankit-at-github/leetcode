class Solution {
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        for(int i=0; i<nums.length; i++)//1. Loop for window/sub-array size.
        {
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            for(int j=i; j<nums.length; j++)//2.Loop for number of times
            {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                ans+= (max-min);
            }
        }
        return ans;
    }
}