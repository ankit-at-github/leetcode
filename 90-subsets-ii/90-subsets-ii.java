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
        if(index >= nums.length)
        {
            if(!output.contains(ans))
                output.add(ans);
            return;
        }
        
        //exclude
        solve(nums, index+1, new ArrayList(ans), output);
        
        //include
        ans.add(nums[index]);
        solve(nums, index+1, ans, output);
    }
}