class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, currentSum = 0;
        for(int i=0; i<nums.length; i++)
        {   
            currentSum+=nums[i];
            
            currentSum = Math.max(currentSum, nums[i]);
            
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}