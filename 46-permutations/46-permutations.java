class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        
        boolean[] visited = new boolean[nums.length];
        
        permutation(nums, 0, visited, output, ans);
        
        return ans;
    }
    public void permutation(int[] nums, int index, boolean[] visited, List<Integer> output, List<List<Integer>> ans)
    {
        if(output.size() == nums.length)
        {
            ans.add(new ArrayList(output));
            return;
        }
        for(int i=0; i<nums.length; i++)
        {
            if(visited[i]) continue;
            
            visited[i] = true;
            output.add(nums[i]);
            permutation(nums, 0, visited, output, ans);
            output.remove(output.size()-1);
            visited[i] = false;
        }
    }
}