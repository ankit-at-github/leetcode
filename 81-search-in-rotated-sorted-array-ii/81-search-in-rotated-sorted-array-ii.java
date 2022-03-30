class Solution {
    public int findIp(int[] nums)
    {
        for(int i=0; i<nums.length-1; i++) if(nums[i] > nums[i+1]) return i+1;
        return 0;
    }
    public boolean search(int[] nums, int target) {
        int ip = findIp(nums);
        if(target == nums[ip]) return true;
        if(ip == 0)
        {
            return binarySearch(nums, 0, nums.length-1, target);
        }
        else if(target >= nums[0])
        {
            return binarySearch(nums, 0, ip, target);
        }
        else
        {
            return binarySearch(nums, ip, nums.length-1, target);
        }
    }
    public boolean binarySearch(int[] nums, int start, int end, int target)
    {
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid] == target) return true;
            else
            {
                if(target > nums[mid]) start = mid+1;
                else end = mid-1;
            }
        }
        return false;
    }
}