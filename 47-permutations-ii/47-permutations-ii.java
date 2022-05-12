class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> output = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        
        boolean[] visited = new boolean[nums.length];
        
        solve(nums, visited);
        
        return ans;
    }
    public void solve(int[] nums, boolean[] visited)
    {
        if(output.size() == nums.length)
        {
            ans.add(new ArrayList(output));
            return;
        }
        for(int i=0; i<nums.length; i++)
        {
            if(visited[i] || (i > 0 && nums[i] == nums[i-1] && !visited[i-1])) continue;
            visited[i] = true;
            output.add(nums[i]);
            solve(nums, visited);
            visited[i] = false;
            output.remove(output.size()-1);
        }
    }
}