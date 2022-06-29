class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        solve(nums, 0, output, ans);
        return ans;
    }
    public void solve(int[] nums, int index, List<Integer> output, List<List<Integer>> ans)
    {
        if(index >= nums.length)
        {
            ans.add(new ArrayList(output));
            return;
        }
        
        //include
        output.add(nums[index]);
        solve(nums, index+1, output, ans);
        
        output.remove(output.size()-1);
        
        //exclude
        solve(nums, index+1, output, ans);
    }
}