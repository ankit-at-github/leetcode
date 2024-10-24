class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftMost = binarySearch(nums, target, true);
        int rightMost = binarySearch(nums, target, false);
        return new int[]{leftMost, rightMost};
    }
    public int binarySearch(int[] nums, int target, boolean leftBiased){
        int left = 0, right = nums.length-1;
        int index = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(target > nums[mid]) left = mid+1;
            else if(target < nums[mid]) right = mid-1;
            else{
                index = mid;
                if(leftBiased) right = mid-1;
                else left = mid+1;
            }
        }
        return index;
    }
}