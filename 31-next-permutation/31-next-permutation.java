class Solution {
    public void nextPermutation(int[] nums) {
        int pivotIndex = getPivot(nums);
        //nums is maximum element so return sorted nums
        if(pivotIndex == -1) reverse(nums, 0, nums.length-1);
        else
        {
            int swapIndex = nums.length-1;
            
            while(swapIndex >= 0 && nums[swapIndex] <= nums[pivotIndex]) swapIndex--;
            
            swap(nums, swapIndex, pivotIndex);
            reverse(nums, pivotIndex+1, nums.length-1);
        }
    }
    public int getPivot(int[] nums)
    {
        int j = nums.length-1;
        while(j > 0 && nums[j-1] >= nums[j]) j--;
        return j-1;
    }
    public void reverse(int[] nums, int start, int end)
    {
        while(start < end)
        {
            swap(nums, start++, end--);
        }
    }
    public void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}