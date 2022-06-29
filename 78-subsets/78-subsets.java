class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        solve(nums, 0, output, ans);
        return ans;
    }
    public void solve(int[] nums, int index, List<Integer> output, List<List<Integer>> ans)
    {
        ans.add(new ArrayList(output));
        
        for(int i=index; i<nums.length; i++)
        {
            output.add(nums[i]);
            solve(nums, i+1, output, ans);
            output.remove(output.size()-1);
        }
    
    }
}