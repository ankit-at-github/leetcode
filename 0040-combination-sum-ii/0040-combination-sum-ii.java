class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, candidates, target, new ArrayList(), ans);
        return ans;
    }
    public void solve(int index, int[] candidates, int target, List<Integer> intermediateResult, List<List<Integer>> ans){
        if(target < 0) return;
        
        if(target == 0){
            ans.add(new ArrayList(intermediateResult));
            return;
        }
        //How to skip duplicates? don't look back : previous elements so i+1
        for(int i=index; i<candidates.length; i++){
            
            if(i > index && candidates[i] == candidates[i-1]) continue;
            
            intermediateResult.add(candidates[i]);
            solve(i+1, candidates, target - candidates[i], intermediateResult, ans);
            intermediateResult.remove(intermediateResult.size()-1);
        }
        
    }
}