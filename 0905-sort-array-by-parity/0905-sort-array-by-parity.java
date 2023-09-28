class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] % 2 == 0)
            {
                swap(left, i, nums);
                left++;
            }
        }
        return nums;
    }
    public void swap(int a, int b, int[]nums)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}