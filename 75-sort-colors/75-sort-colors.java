class Solution {
    public void sortColors(int[] nums) {
        int zeroes = 0;
        int ones = 0;
        int twoes = 0;
        for(int x : nums)
        {
            if(x == 0) zeroes++;
            if(x == 1) ones++;
            if(x == 2) twoes++;
        }
        for(int i=0; i<nums.length; i++)
        {
            if(zeroes-- > 0) nums[i] = 0;
            else if(ones-- > 0) nums[i] = 1;
            else
            {
                nums[i] = 2;
                twoes--;
            }
        }
    }
}