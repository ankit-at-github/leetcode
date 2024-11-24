class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, new ArrayList(), ans);
        return ans;
    }
    public void solve(int index, int[] nums, List<Integer> current, List<List<Integer>> ans){
        ans.add(new ArrayList(current));
        
        for(int i=index; i<nums.length; i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            current.add(nums[i]);
            solve(i+1, nums, current, ans);
            current.remove(current.size() - 1);
        }
    }
}