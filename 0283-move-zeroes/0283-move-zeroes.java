class Solution {
    public void moveZeroes(int[] nums) {
        int left = -1, right = left+1;
        while(right < nums.length){
            if(nums[right] != 0){
                left++;
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            right++;
        }
    }
}