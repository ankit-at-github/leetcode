class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        
        if(nums[low] <= nums[high]) return binarySearch(nums, low, high, target);
        
        //gettingPivotIndex - Index where array elements are rotated.
        int pivotIndex = getPivotIndex(nums);
         
        
        if(pivotIndex != low)
        {
            //Adjusting low or high based on target element.
            if(target >= nums[0]) high = pivotIndex-1;
            else low = pivotIndex;
        }
        
        return binarySearch(nums, low, high, target);
        
    }
    public int binarySearch(int[] nums, int low, int high, int target)
    {
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            else
            {
                if(nums[mid] < target) low = mid+1;
                else high = mid-1;
            }
        }
        return -1;
    }
    public int getPivotIndex(int[] nums)
    {
        int low = 0, high = nums.length-1;
        while(low < high)
        {
            int mid = low + (high-low)/2;
            
            if(nums[mid] > nums[low])
                low = mid;
            else
                high = mid;
        }
        return low+1;
    }
}