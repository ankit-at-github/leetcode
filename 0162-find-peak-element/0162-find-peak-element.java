class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int n = nums.length;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;
        int low = 1, high = n-2;
        while(low <= high){
            int mid = low + (high-low) / 2;
            
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            
            if(nums[mid] > nums[mid-1]) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}