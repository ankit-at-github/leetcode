class Solution {
    public void nextPermutation(int[] nums) {
        //1. Find Pivot
        int pivot = findPivot(nums);
        //This means numbers is in decreasing order
        if(pivot == -1)
            reverse(nums, 0, nums.length-1);
        else
        {
            //2. Find swap index
            int i = nums.length-1;
            while(nums[pivot] >= nums[i]) i--;
            
            swap(nums, pivot, i);
            
            reverse(nums, pivot+1, nums.length-1);
        }
    }
    int findPivot(int[] nums)
    {
        int i = nums.length-1;
        while(i > 0 && nums[i] <= nums[i-1]) i--;
        return i-1;
    }
    void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    void reverse(int[] nums, int start, int end)
    {
        while(start < end)
        {
            swap(nums, start++, end--);
        }
    }
}