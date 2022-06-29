class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        
        Arrays.sort(candidates);
        
        solve(candidates, 0, target, output, ans);
        return ans;
    }
    public void solve(int[] candidates, int index, int target, List<Integer> output, List<List<Integer>> ans)
    {
        //base Conditions
        if(target == 0)
        {
            ans.add(new ArrayList(output));
            return;
        }
        for(int i=index; i<candidates.length; i++)
        {
            if(target-candidates[i] < 0) break;
            
            output.add(candidates[i]);
            solve(candidates, i, target-candidates[i], output, ans);
            output.remove(output.size()-1);
        }
    }
}