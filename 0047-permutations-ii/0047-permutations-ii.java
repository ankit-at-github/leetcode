class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        solve(nums, new ArrayList<Integer>(), ansList, visited);
        return ansList;
    }
    public void solve(int[] nums, List<Integer> intermediateList, List<List<Integer>> ans, boolean[] visited){
        if(intermediateList.size() == nums.length){
            ans.add(new ArrayList(intermediateList));
        }
        for(int i=0; i<nums.length; i++){
            if(visited[i] || (i > 0 && nums[i] == nums[i-1] && !visited[i-1])) continue;
            visited[i] = true;
            intermediateList.add(nums[i]);
            solve(nums, intermediateList, ans, visited);
            intermediateList.remove(intermediateList.size()-1);
            visited[i] = false;
        }
    }
}