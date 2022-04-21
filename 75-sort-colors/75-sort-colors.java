class Solution {
    public void sortColors(int[] nums) {
        //Solving this using 3 pointer approach. This approach can be used to solve any 3 distinct elements present in an array.
        
        int low = 0, mid = 0, high = nums.length-1;
        
        while(mid <= high)
        {
            if(nums[mid] == 0)
            {
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1) mid++;
            else
            {
                swap(nums, mid, high);
                high--;
            }
        }
        
    }
    public void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}