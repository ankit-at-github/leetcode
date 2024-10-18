class Solution {
    public void nextPermutation(int[] nums) {
        //1. Pivot Index
        //2. Swap Index
        //3. Swap Values
        //4. Reverse rest numbers from pivotIndex till n-1.
        int pivotIndex = nums.length-1;
        while(pivotIndex > 0 && nums[pivotIndex] <= nums[pivotIndex-1]){
            pivotIndex--;
        }
        pivotIndex--;
        if(pivotIndex == -1) reverse(nums, 0, nums.length-1);
        else{
            int swapIndex = nums.length-1;
            while(swapIndex >= 0 && nums[swapIndex] <= nums[pivotIndex]){
                swapIndex--;
            }
            swap(nums, swapIndex, pivotIndex);
            reverse(nums, pivotIndex+1, nums.length-1);
        }
    }
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}