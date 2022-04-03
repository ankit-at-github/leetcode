class Solution {
    public void nextPermutation(int[] nums) {
        //1.Find Pivot Index where longest increasing suffix breaks;
        int pivotIndex = nums.length-2;
        while(pivotIndex >=0 && nums[pivotIndex] >= nums[pivotIndex+1]) pivotIndex--;
        
        if(pivotIndex == -1) reverse(nums, 0, nums.length-1);
        else
        {
            //2. Find correct succesor of element at pivotIndex from right, more formally swap with element greater than nums[pivotIndex] as we next greater.
            int swapIndex = nums.length-1;
            while(swapIndex>=0 && nums[pivotIndex] >= nums[swapIndex]) swapIndex--;
            
            //3. Swap the elements
            swap(nums, swapIndex, pivotIndex);
            
            //4. Reverse element from pivotIndex+1;
            reverse(nums, pivotIndex+1, nums.length-1);
        }
    }
    public void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void reverse(int[] nums, int start, int end)
    {
        while(start<end)
        {
            swap(nums, start++, end--);
        }
    }
}