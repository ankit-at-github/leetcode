class Solution {
    public int maxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i=0; i<nums.length; i++){
            currentSum+=nums[i];
            if(currentSum < nums[i]) currentSum = nums[i];
            maxi = Math.max(maxi, currentSum);
        }
        return maxi;
    }
}