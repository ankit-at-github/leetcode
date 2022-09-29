class Solution {
    public void nextPermutation(int[] nums) {
        
        //1. Finding Pivot Index from right
        
        int pivotIndex = getPivot(nums);
        
        //numbers are in decreasing order no next permuation availabe
        if(pivotIndex == -1) reverse(nums, 0, nums.length-1);
        else
        {
            //2. Find Swapping Index
            int swapIndex = nums.length-1;
            while(swapIndex >= 0 && nums[swapIndex] <= nums[pivotIndex]) swapIndex--;
            
            //3. Swap value at PivotIndex and SwapIndex
            swap(nums, swapIndex, pivotIndex);
            //4. Reverse remaining
            reverse(nums, pivotIndex+1, nums.length-1);
        }
    }
    public int getPivot(int[] nums)
    {
        int i = nums.length-1;
        while(i>0 && nums[i-1] >= nums[i]) i--;
        return i-1;
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