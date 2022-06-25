class Solution {
    public boolean checkPossibility(int[] nums) {
        int violation = 0;
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i-1] > nums[i])
            {
                violation++;
                
                if(violation > 1) return false;
                
                //Violation found With what value nums[i] should be changed
                if(i-2 >=0 && nums[i-2] > nums[i])
                {
                    nums[i] = nums[i-1];
                }
                else nums[i-1] = nums[i];
            }
        }
        return true;
    }
}