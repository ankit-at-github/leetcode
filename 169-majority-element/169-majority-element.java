class Solution {
    public int majorityElement(int[] nums) {
        int majorityIndex=0;
        int count = 1;
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i] == nums[majorityIndex]) count++;
            else
            {
                count--;
                if(count == 0)
                {
                    count = 1;
                    majorityIndex = i;
                }
            }
        }
        return nums[majorityIndex];
    }
}