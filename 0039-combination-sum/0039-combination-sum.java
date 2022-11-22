class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        
        Arrays.sort(candidates);
        
        solve(0, candidates, target, output, ans);
        
        return ans;
    }
    public void solve(int index, int[] candidates, int target, List<Integer> output, List<List<Integer>> ans)
    {
        if(target == 0)
        {
            ans.add(new ArrayList(output));
            return;
        }
        
        for(int i=index; i<candidates.length; i++)
        {
            if(target-candidates[i] < 0) break;
            
            output.add(candidates[i]);
            solve(i, candidates, target-candidates[i], output, ans);
            output.remove(output.size()-1);
        }
        
    }
}