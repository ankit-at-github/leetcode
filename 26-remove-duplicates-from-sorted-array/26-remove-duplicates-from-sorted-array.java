class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        while(j < nums.length)
        {
            if(nums[j]!=nums[i])
            {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            j++;
        }
        return i+1;
    }
}