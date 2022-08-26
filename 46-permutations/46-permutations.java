class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, 0, ans);
        return ans;
    }
    public void solve(int[] nums, int index, List<List<Integer>> ans)
    {
        if(index == nums.length)
        {
            List<Integer> output = new ArrayList<>();
            for(int x : nums) output.add(x);
            ans.add(output);
        }
        
        for(int j=index; j<nums.length; j++)
        {
            swap(nums, index, j);
            solve(nums, index+1, ans);
            swap(nums, index, j);
        }
    }
    public void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}