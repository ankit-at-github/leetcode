class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        
        Arrays.sort(nums);
        
        boolean[] visited = new boolean[nums.length];
        
        solve(nums, visited, output, ans);
        
        return ans;
    }
    public void solve(int[] nums, boolean[] visited, List<Integer> output, List<List<Integer>> ans)
    {
        if(output.size() == nums.length)
        {
            if(!ans.contains(output))
            ans.add(new ArrayList(output));
            return;
        }
        for(int i=0; i<nums.length; i++)
        {
            if(visited[i]) continue;
            visited[i] = true;
            output.add(nums[i]);
            solve(nums, visited, output, ans);
            visited[i] = false;
            output.remove(output.size()-1);
        }
    }
}