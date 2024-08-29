class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> intermediateList = new ArrayList<>();
        solve(nums, intermediateList, ansList);
        return ansList;
    }
    public void solve(int[] nums, List<Integer> intermediateList, List<List<Integer>> ans){
        if(intermediateList.size() == nums.length){
            ans.add(new ArrayList(intermediateList));
        }
        
        for(int i=0; i<nums.length; i++){
            if(intermediateList.contains(nums[i])) continue;
            intermediateList.add(nums[i]);
            solve(nums, intermediateList, ans);
            intermediateList.remove(intermediateList.size()-1);
        }
    }
}