class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        for(int x : nums) rightSum+=x;
        
        for(int i=0; i<nums.length; i++)
        {
            if(rightSum-nums[i]-leftSum == leftSum) return i;
            leftSum+=nums[i];
        }
        return -1;
    }
}