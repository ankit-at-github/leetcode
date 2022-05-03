class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l = 0, r = nums.length-1;
        int maxi = 0, mini = nums.length-1;
        int i=0, j = nums.length-1;
        while(i<nums.length && j >=0)
        {
            //finding next Max Element
            if(nums[i] > nums[maxi]) maxi = i;
            else if(nums[i] < nums[maxi]) l = i;
            
            //finding next Min Element
            if(nums[j] < nums[mini]) mini = j;
            else if(nums[j] > nums[mini]) r = j;
            
            i++;
            j--;
        }
        if(r >= l) return 0;
        else return l-r+1;
    }
}