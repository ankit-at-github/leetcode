class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int countZeroes = 0;
        int maxi = 0;
        while(right < nums.length){
            if(nums[right] == 0) countZeroes++;
            
            while(countZeroes > k){
                if(nums[left] == 0) countZeroes--;
                left++;
            }
            
            maxi = Math.max(maxi, right-left+1);
            right++;
        }
        return maxi;
    }
}