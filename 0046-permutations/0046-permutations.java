class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, new ArrayList(), ans);
        return ans;
    }
    public void solve(int[] nums, List<Integer> intermediateResult, List<List<Integer>> ans){
        if(intermediateResult.size() == nums.length){
            ans.add(new ArrayList(intermediateResult));
            return;
        }
        for(int i=0; i<nums.length; i++){
            
            if(intermediateResult.contains(nums[i])) continue;
            
            intermediateResult.add(nums[i]);
            solve(nums, intermediateResult, ans);
            intermediateResult.remove(intermediateResult.size()-1);
        }
    }
}