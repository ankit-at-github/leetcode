class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int maxiCount = 0;
        for(int right = 0; right<nums.length; right++)
        {
            if(nums[right] == 0)
            {
                left = right+1;
            }
            maxiCount = Math.max(maxiCount, right-left+1);
        }
        return maxiCount;
    }
}