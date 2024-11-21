class Solution {
    public int maxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for(int n : nums){
            sum+=n;
            
            sum = Math.max(sum, n);
            
            maxi = Math.max(maxi, sum);
        }
        return maxi;
    }
}