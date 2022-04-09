class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean notIncreasing = false;
        boolean notDecreasing = false;
        for(int i=0; i<nums.length-1; i++)
        {
            if(nums[i] > nums[i+1]) notIncreasing = true;
        }
        for(int i=0; i<nums.length-1; i++)
        {
            if(nums[i] < nums[i+1]) notDecreasing = true;
        }
        
        if(notIncreasing && notDecreasing) return false;
        else return true;
    }
}