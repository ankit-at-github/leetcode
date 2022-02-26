class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int peak = 0;
        for(int i=1; i<n-1; i++)
        {
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) return i;
        }
        if(nums[0] > nums[n-1]) return 0;
        else return n-1;
    }
}