class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++)
        {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            twoPointer(i, nums, ans);
        }
        return ans;
    }
    public void twoPointer(int i, int[] nums, List<List<Integer>> ans)
    {
        int j = i+1, k = nums.length-1;
        
        while(j < k)
        {
            if(nums[i] + nums[j] + nums[k] > 0) k--;
            else if(nums[i] + nums[j] + nums[k] < 0) j++;
            else
            {
                ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                j++;
                k--;
                while(j<k && nums[j] == nums[j-1] && nums[k] == nums[k+1])
                {
                    j++;
                    k--;
                }
            }
        }
    }
}