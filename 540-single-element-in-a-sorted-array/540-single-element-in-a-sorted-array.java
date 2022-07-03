class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length-1;
        while(low < high)
        {
            
            int mid = low + (high-low)/2;
            //since mid is even so for correct pair next element should be same at odd position, and violater is on right side.
            if(mid%2 == 0)
            {
                if(nums[mid] == nums[mid+1]) low = mid+2;
                else high = mid;
            }
            else
            {
                if(nums[mid] == nums[mid+1]) high = mid;
                else low = mid+1;
            }
        }
        
        return nums[low];
    }
}