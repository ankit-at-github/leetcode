class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(nums.length == 0) return res;
        
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++)
        {
            //skip duplicates
            if(i > 0 && nums[i-1] == nums[i]) continue;
            
            twoSumPointer(nums, i, res);
        }
        return res;
    }
    public void twoSumPointer(int[] nums, int index, List<List<Integer>> res)
    {
        int i=index+1, j=nums.length-1;
        while(i < j)
        {
            int sum = nums[index] + nums[i] + nums[j];
            if(sum < 0) i++;
            else if(sum > 0) j--;
            else
            {
                res.add(Arrays.asList(nums[index], nums[i], nums[j]));
                i++;
                j--;
                //skip duplicates
                while(i < j && nums[i-1]==nums[i] && nums[j] == nums[j+1])
                {
                    i++;
                    j--;
                }
            }
        }
    }
}