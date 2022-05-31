class Solution {
    public void nextPermutation(int[] nums) {
        //1. Finding Pivot Index backward
        int pivotIndex = -1;
        for(int i=nums.length-1; i>=1; i--)
        {
            if(nums[i-1] < nums[i])
            {
                pivotIndex = i-1;
                break;
            }
        }
        
        if(pivotIndex >= 0)
        {
            //2. Finding Successor
            int swapIndex = nums.length-1;
            while(nums[swapIndex] <= nums[pivotIndex]) swapIndex--;
            
            //3. Swap the Elements
            swap(nums, pivotIndex, swapIndex);
            
            //4. Reverse the elements from pivotIndex+1
            reverse(nums, pivotIndex+1);
        }
        else
            reverse(nums, 0);
    }
    void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    void reverse(int[] nums, int start)
    {
        int end = nums.length-1;
        while(start < end)
        {
            swap(nums, start++, end--);
        }
    }
}