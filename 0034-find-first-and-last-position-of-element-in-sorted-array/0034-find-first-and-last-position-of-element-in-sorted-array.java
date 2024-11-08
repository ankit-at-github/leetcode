class Solution {
    public int[] searchRange(int[] nums, int target) {
        //if found at mid, continue searching left or right
        return new int[]{leftMost(nums, target), rightMost(nums, target)};
    }
    public int leftMost(int[] nums, int target){
        int start = 0, end = nums.length-1;
        int result = -1;
        while(start <= end){
            int mid = start + (end-start) / 2;
            
            if(nums[mid] == target){
                result = mid;
                end = mid-1;
            }else if(nums[mid] < target) start = mid+1;
            else end = mid-1; 
        }
        return result;
    }
    public int rightMost(int[] nums, int target){
        int start = 0, end = nums.length-1;
        int result = -1;
        while(start <= end){
            int mid = start + (end-start) / 2;
            
            if(nums[mid] == target){
                result = mid;
                start = mid+1;
            }else if(nums[mid] < target) start = mid+1;
            else end = mid-1; 
        }
        return result;
    }
}