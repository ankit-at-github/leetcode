class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int zeroes = 0;
        int maxi = 0;
        while(right < nums.length){
            if(nums[right] == 0) zeroes++;
            while(zeroes > k){
                if(nums[left] == 0) zeroes--;
                left++;
            }
            maxi = Math.max(maxi, right - left + 1);
            right++;
        }
        return maxi;
    }
}