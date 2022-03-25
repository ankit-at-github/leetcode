class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        
        List<List<Integer>> output = new ArrayList<>();
        
        solve(candidates, 0, new ArrayList(), output, target);
        
        return output;
    }
    public void solve(int[] candidates, int index, List<Integer> temp, List<List<Integer>> output, int target)
    {
        if(target == 0) output.add(new ArrayList(temp));
        
        for(int i=index; i<candidates.length; i++)
        {
            if((i > index && candidates[i] == candidates[i-1])) continue;
            if(target < candidates[i]) break;
            
            temp.add(candidates[i]);
            solve(candidates, i+1, temp, output, target-candidates[i]);
            temp.remove(temp.size()-1);
        }
    }
}