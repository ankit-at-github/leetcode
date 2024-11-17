class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        //How to skip duplicates? Start from same index
        for(int i=index; i<candidates.length; i++){
            intermediateResult.add(candidates[i]);
            solve(i, candidates, target - candidates[i], intermediateResult, ans);
            intermediateResult.remove(intermediateResult.size()-1);
        }
        
    }
}