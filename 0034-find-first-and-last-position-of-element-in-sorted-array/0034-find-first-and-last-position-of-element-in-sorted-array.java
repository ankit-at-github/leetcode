class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = leftmost(nums, target);
        ans[1] = rightmost(nums, target);
        return ans;
    }
    public int leftmost(int[] nums, int target)
    {
        int start = 0, end = nums.length-1;
        int leftmost = -1;
        while(start <= end)
        {
            int mid = start+(end-start)/2;
            if(nums[mid] == target)
            {
                leftmost = mid;
                end = mid-1;
            }
            if(nums[mid] < target) start = mid+1;
            if(nums[mid] > target) end = mid-1;
        }
        return leftmost;
    }
    public int rightmost(int[] nums, int target)
    {
        int start = 0, end = nums.length-1;
        int rightmost = -1;
        while(start <= end)
        {
            int mid = start+(end-start)/2;
            if(nums[mid] == target)
            {
                rightmost = mid;
                start = mid+1;
            }
            if(nums[mid] < target) start = mid+1;
            if(nums[mid] > target) end = mid-1;
        }
        return rightmost;
    }
}