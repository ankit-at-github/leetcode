class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        
        solve(nums, 0, ans, output);
        
        return output;
    }
    public void solve(int[] nums, int index, List<Integer> ans, List<List<Integer>> output)
    {
        output.add(new ArrayList(ans));
        
        for(int i=index; i<nums.length; i++)
        {
            if(i>index && nums[i]==nums[i-1]) continue;
            ans.add(nums[i]);
            solve(nums, i+1, ans, output);
            ans.remove(ans.size()-1);
        }
    }
}