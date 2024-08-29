class Solution {
    public void nextPermutation(int[] nums) {
        int pivotIndex = -1;
        int n = nums.length;
        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                pivotIndex = i;
                break;
            }
        }
        if(pivotIndex == -1){
            reverse(nums, 0, n-1);
        }
        else{
            int swapIndex = n-1;
            while(nums[swapIndex] <= nums[pivotIndex]) swapIndex--;
            swap(nums, pivotIndex, swapIndex);
            reverse(nums, pivotIndex+1, n-1);
        }
    }
    public void swap(int[] nums, int pivotIndex, int swapIndex){
        int temp = nums[pivotIndex];
        nums[pivotIndex] = nums[swapIndex];
        nums[swapIndex] = temp;
    }
    public void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}