class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int index=0; index<nums.length; index++)
        {
            if(index > 0 && nums[index] == nums[index-1]) continue;
            
            twoPointer(index, nums, ans);
        }
        return ans;
    }
    public void twoPointer(int index, int[] nums, List<List<Integer>> ans)
    {
        int start = index+1, end = nums.length-1;
        while(start < end)
        {
            if(nums[index] + nums[start] + nums[end] > 0) end--;
            else if(nums[index] + nums[start] + nums[end] < 0) start++;
            else
            {
                ans.add(Arrays.asList(nums[index], nums[start], nums[end]));
                start++;
                end--;
                
                while(start < end && nums[start] == nums[start-1]) start++;
            }
        }
    }
}