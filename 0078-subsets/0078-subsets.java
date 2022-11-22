class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        
        solve(0, nums, output, ans);
        
        return ans;
    }
    public void solve(int index, int[] nums, List<Integer> output, List<List<Integer>> ans)
    {
        ans.add(new ArrayList(output));
        
        for(int i=index; i<nums.length; i++)
        {
            output.add(nums[i]);
            solve(i+1, nums, output, ans);
            output.remove(output.size()-1);
        }
        
    }
}