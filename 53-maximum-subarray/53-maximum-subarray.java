class Solution {
    public int maxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for(int x : nums)
        {
            sum+=x;
            sum = Math.max(sum, x);
            maxi = Math.max(maxi, sum);
        }
        return maxi;
    }
}