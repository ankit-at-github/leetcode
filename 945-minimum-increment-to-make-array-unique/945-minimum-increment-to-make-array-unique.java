class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int exp = nums[0]+1;
        int increment = 0;
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i] < exp) increment+=exp-nums[i];
            else exp = nums[i];
            
            exp++;
        }
        return increment;
    }
}