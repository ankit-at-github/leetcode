class Solution {
    public void solve(int[] nums, int start, List<Integer> temp, boolean[] visited, List<List<Integer>> ans)
    {
        if(temp.size() == nums.length) ans.add(new ArrayList(temp));
        
        for(int i=0; i<nums.length; i++)
        {
            if(visited[i] || (i > 0 && nums[i] == nums[i-1] && !visited[i-1])) continue;
            
            temp.add(nums[i]);
            visited[i] = true;
            solve(nums, i, temp, visited, ans);
            visited[i] = false;
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        
        boolean[] visited = new boolean[nums.length];
        
        solve(nums, 0, new ArrayList<>(), visited, ans);
        
        return ans;
    }
    
}