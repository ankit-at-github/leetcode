class Solution {
    public int triangularSum(int[] nums) {
        int run = nums.length;
        while(run > 1)
        {
            for(int i=0; i<run-1; i++)
            {
                nums[i] = (nums[i]+nums[i+1])%10;
            }
            run-=1;
        }
        return nums[0];
    }
}