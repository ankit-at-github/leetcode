class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int zeroes = 0, maxiCount = 0;
        while(right < nums.length)
        {
            if(nums[right] == 0)
            {
                zeroes++;
                while(zeroes > k)
                {
                    if(nums[left] == 0) zeroes--;
                    left++;
                }
            }
            maxiCount = Math.max(maxiCount, right-left+1);
            right++;
        }
        return maxiCount;
    }
}