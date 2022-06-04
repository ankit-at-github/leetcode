class Solution {
    public void sortColors(int[] nums) {
        int start = 0, mid = 0, end = nums.length-1;
        while(mid <= end)
        {
            if(nums[mid] == 0)
            {
                swap(nums, start, mid);
                start++;
                mid++;
            }
            
            else if(nums[mid] == 1) mid++;
            
            else
            {
                swap(nums, mid, end);
                end--;
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