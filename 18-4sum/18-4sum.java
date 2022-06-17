class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++)
        {
            if(i > 0 && nums[i-1] == nums[i]) continue;
            
            threeSum(nums, i, res, (long)target-nums[i]);
        }
        return res;
    }
    public void threeSum(int[] nums, int index1, List<List<Integer>> res, long target)
    {
        for(int j=index1+1; j<nums.length; j++)
        {
            if(j>index1+1 && nums[j-1] == nums[j]) continue;
            
            twoSum(nums, index1, j, res, (long)target-nums[j]);
        }
    }
    public void twoSum(int[] nums, int index1, int index2, List<List<Integer>> res, long target)
    {
        int i=index2+1, j=nums.length-1;
        while(i<j)
        {
            long sum = nums[i] + nums[j];
            
            if(sum < target) i++;
            else if(sum > target) j--;
            else
            {
                res.add(Arrays.asList(nums[index1], nums[index2], nums[i], nums[j]));
                i++;j--;
                while(i<j && nums[i-1]==nums[i] && nums[j]==nums[j+1])
                {
                    i++;
                    j--;
                }
            }
        }
    }
}