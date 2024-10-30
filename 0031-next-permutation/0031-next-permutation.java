class Solution {
    public void nextPermutation(int[] nums) {
        int pivotIndex = -1;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                pivotIndex = i;
                break;
            }
        }
        
        if(pivotIndex == -1) reverse(nums, 0, nums.length-1);
        else{
            int swapIndex = nums.length-1;
            while(nums[swapIndex] <= nums[pivotIndex]) swapIndex--;
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