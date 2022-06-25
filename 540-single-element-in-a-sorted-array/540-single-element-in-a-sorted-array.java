class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length-1;
        while(low < high)
        {
            int mid = low + (high-low)/2;
            
            //Now check if you are one the right side of violated element or left side.
            //Every pair starts from even index and the pair of index becomes (even-odd), however
            //as soon as you encounter violated element this changes and pair of index becomes (odd-even)
            //Using this fact.
            if(mid%2 == 0)
            {
                //Following normal convention (even-odd) pair violated element is on right side
                //else not following violated element is on left side.
                
                if(nums[mid] == nums[mid+1]) low = mid+2;
                else high = mid;
            }
            else
            {
                if(nums[mid] == nums[mid-1]) low = mid+1;
                else high = mid;
            }
        }
        return nums[low];
    }
}