class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList());
        
        List<Integer> output = new ArrayList<>();
        
        solve(0, nums, output, ans);
        
        return ans;
    }
    public void solve(int index, int[] nums, List<Integer> output, List<List<Integer>> ans)
    {
        if(index >= nums.length)
        {
            return;
        }
        
        for(int i=index; i<nums.length; i++)
        {
            output.add(nums[i]);
            ans.add(new ArrayList(output));
            solve(i+1, nums, output, ans);
            output.remove(output.size()-1);
        }
        
    }
}