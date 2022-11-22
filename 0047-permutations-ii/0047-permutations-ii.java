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
        if(output.size() == nums.length) ans.add(new ArrayList(output));
        
        for(int i=0; i<nums.length; i++)
        {
            if(visited[i]) continue;
            
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            
            output.add(nums[i]);
            visited[i] = true;
            solve(nums, visited, output, ans);
            output.remove(output.size()-1);
            visited[i] = false;
        }
    }
}